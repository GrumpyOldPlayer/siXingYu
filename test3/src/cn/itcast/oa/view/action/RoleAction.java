package cn.itcast.oa.view.action;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Category;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

    private Long[] privilegeIds;

    /**
     * 列表
     */
    public String list() throws Exception {
        List<Role> roleList = roleService.findAll();
        ActionContext.getContext().put("roleList", roleList);
        return "list";
    }

    /**
     * 删除
     */
    public String delete() throws Exception {
        roleService.delete(model.getId());
        return "toList";
    }

    /**
     * 添加页面
     */
    public String addUI() throws Exception {
        return "saveUI";
    }

    /**
     * 添加
     */
    public String add() throws Exception {
        // // 封装到对象中
        // Role role = new Role();
        // role.setName(model.getName());
        // role.setDescription(model.getDescription());
        //
        // // 保存到数据库
        // roleService.save(role);

        roleService.save(model);

        return "toList";
    }

    /**
     * 修改页面
     */
    public String editUI() throws Exception {
        // 准备回显的数据
        Role role = roleService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(role);

        return "saveUI";
    }

    /**
     * 修改
     */
    public String edit() throws Exception {
        // 1，从数据库中获取原对象
        Role role = roleService.getById(model.getId());

        // 2，设置要修改的属性
        role.setName(model.getName());
        role.setDescription(model.getDescription());

        // 3，更新到数据库
        roleService.update(role);

        return "toList";
    }

    /**
     * 设置权限页面
     */
    public String setPrivilegeUI() throws Exception {
        // 准备回显的数据
        Role role = roleService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(role);

        if (role.getPrivileges() != null) {
            privilegeIds = new Long[role.getPrivileges().size()];
            int index = 0;
            for (Privilege priv : role.getPrivileges()) {
                privilegeIds[index++] = priv.getId();
            }
        }

        // 准备数据 privilegeList
        List<Privilege> privilegeList = privilegeService.findAll();
        ActionContext.getContext().put("privilegeList", privilegeList);

        return "setPrivilegeUI";
    }

    /**
     * 设置权限
     */
    public String setPrivilege() throws Exception {
        // 1，从数据库中获取原对象
        Role role = roleService.getById(model.getId());

        // 2，设置要修改的属性
        List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
        role.setPrivileges(new HashSet<Privilege>(privilegeList));

        // 3，更新到数据库
        roleService.update(role);

        return "toList";
    }

    /**
     * 查询
     */
    public String select() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        String strText = request.getParameter("strText");
        if (strText == null || strText.equals("")) {
            return "toList";
        }

        List<Role> roleList = roleService.findRoles(strText);
        ActionContext.getContext().put("roleList", roleList);
        ActionContext.getContext().put("strText", strText);
        return "list";
    }

    public Long[] getPrivilegeIds() {
        return privilegeIds;
    }

    public void setPrivilegeIds(Long[] privilegeIds) {
        this.privilegeIds = privilegeIds;
    }

}
