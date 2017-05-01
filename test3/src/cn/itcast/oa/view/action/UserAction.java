package cn.itcast.oa.view.action;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Category;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Mianfei;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.Shoufei;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.util.DepartmentUtils;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

    private Long departmentId;
    private Long[] roleIds;

    /**
     * 列表
     */
    public String list() throws Exception {

        List<User> users = userService.findAll();
        ActionContext.getContext().put("users", users);

        return "list";
    }

    /**
     * 删除
     */
    public String delete() throws Exception {
        userService.delete(model.getId());
        return "toList";
    }

    /**
     * 添加页面
     */
    public String addUI() throws Exception {
        // 准备数据, departmentList
        List<Department> topList = departmentService.findTopList();
        List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
        ActionContext.getContext().put("departmentList", departmentList);

        // 准备数据, roleList
        List<Role> roleList = roleService.findAll();
        ActionContext.getContext().put("roleList", roleList);

        return "saveUI";
    }

    /**
     * 添加
     */
    public String add() throws Exception {
        // 封装到对象中（当model是实体类型时，也可以使用model，但要设置未封装的属性）
        // >> 设置所属部门
        model.setDepartment(departmentService.getById(departmentId));
        // >> 设置关联的岗位
        List<Role> roleList = roleService.getByIds(roleIds);
        model.setRoles(new HashSet<Role>(roleList));
        // >> 设置默认密码为1234（要使用MD5摘要）
        String md5Digest = DigestUtils.md5Hex("1234");
        model.setPassword(md5Digest);

        // 保存到数据库
        userService.save(model);

        return "toList";
    }

    /**
     * 修改页面
     */
    public String editUI() throws Exception {
        // 准备数据, departmentList
        List<Department> topList = departmentService.findTopList();
        List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
        ActionContext.getContext().put("departmentList", departmentList);

        // 准备数据, roleList
        List<Role> roleList = roleService.findAll();
        ActionContext.getContext().put("roleList", roleList);

        // 准备回显的数据
        User user = userService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(user);
        if (user.getDepartment() != null) {
            departmentId = user.getDepartment().getId();
        }
        if (user.getRoles() != null) {
            roleIds = new Long[user.getRoles().size()];
            int index = 0;
            for (Role role : user.getRoles()) {
                roleIds[index++] = role.getId();
            }
        }

        return "saveUI";
    }

    /**
     * 修改
     */
    public String edit() throws Exception {
        // 1，从数据库中取出原对象
        User user = userService.getById(model.getId());

        // 2，设置要修改的属性
        user.setLoginName(model.getLoginName());
        user.setName(model.getName());
        user.setGender(model.getGender());
        user.setPhoneNumber(model.getPhoneNumber());
        user.setEmail(model.getEmail());
        user.setDescription(model.getDescription());
        if (model.getPassword() != null && !model.getPassword().equals("")) {
            // 2，设置要修改的属性（要使用MD5摘要）
            String md5Digest = DigestUtils.md5Hex(model.getPassword());
            user.setPassword(md5Digest);
        }

        // >> 设置所属部门
        user.setDepartment(departmentService.getById(departmentId));
        // >> 设置关联的岗位
        List<Role> roleList = roleService.getByIds(roleIds);
        user.setRoles(new HashSet<Role>(roleList));

        // 3，更新到数据库
        userService.update(user);
        if (model.getPassword() != null && !model.getPassword().equals("")) {
            return "oneUserU";
        } else {
            return "toList";
        }

    }

    /**
     * 初始化密码为1234
     */
    public String initPassword() throws Exception {
        // 1，从数据库中取出原对象
        User user = userService.getById(model.getId());

        // 2，设置要修改的属性（要使用MD5摘要）
        String md5Digest = DigestUtils.md5Hex("1234");
        user.setPassword(md5Digest);

        // 3，更新到数据库
        userService.update(user);

        return "toList";
    }

    /**
     * 登录页面
     */
    public String loginUI() throws Exception {
        return "loginUI";
    }

    /**
     * 登录
     */
    public String login() throws Exception {
        HttpServletResponse response = null;
        response = ServletActionContext.getResponse();
        ;
        response.setContentType("text/html;charset=utf-8");
        User user = userService.findByLoginNameAndPassword(model.getLoginName(), model.getPassword());
        if (user == null) {
            addFieldError("login", "账号或者密码错误");
            return "loginUI";
        } else {
            // 登录用户
            ActionContext.getContext().getSession().put("user", user);
            return "toIndex";
        }
    }

    /**
     * 注销
     */
    public String logout() throws Exception {
        ActionContext.getContext().getSession().remove("user");
        return "logout";
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
        List<User> users = userService.findUsers(strText);
        ActionContext.getContext().put("users", users);
        ActionContext.getContext().put("strText", strText);
        return "list";
    }
    // ---

    public String one() throws Exception {
        // 准备数据, departmentList
        List<Department> topList = departmentService.findTopList();
        List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
        ActionContext.getContext().put("departmentList", departmentList);

        // 准备数据, roleList
        List<Role> roleList = roleService.findAll();
        ActionContext.getContext().put("roleList", roleList);

        // 准备回显的数据
        User user = (User) ActionContext.getContext().getSession().get("user");
        user.setPassword("");
        ActionContext.getContext().getValueStack().push(user);
        if (user.getDepartment() != null) {
            departmentId = user.getDepartment().getId();
        }
        if (user.getRoles() != null) {
            roleIds = new Long[user.getRoles().size()];
            int index = 0;
            for (Role role : user.getRoles()) {
                roleIds[index++] = role.getId();
            }
        }
        return "one";
    }


    public String mf() throws Exception {
        User user = (User) ActionContext.getContext().getSession().get("user");
        List<Mianfei> Mianfeilis = mianfeiService.userID(user.getId());
        for (Mianfei Mianfei : Mianfeilis) {
            if (Mianfei.getUserid() != null) {
                Mianfei.setUser(user);
            }
        }
        ActionContext.getContext().put("MianfeiList", Mianfeilis);
        return "onexiaoxilist";
    }

    /**
     * 修改页面
     */
    public String oneeditUI() throws Exception {
        // 准备回显的数据
        Mianfei role = mianfeiService.getById(model.getId());
        if (role != null) {
            User user = userService.getById(Long.valueOf(role.getUserid()));
            role.setUser(user);
        }
        ActionContext.getContext().getValueStack().push(role);
        return "oneeditUI";
    }

    public String sf() throws Exception {
        User user = (User) ActionContext.getContext().getSession().get("user");
        List<Shoufei> Shoufeis = shoufeiService.userID(user.getId());
        for (Shoufei shoufei : Shoufeis) {
            if (shoufei.getUserid() != null) {
                shoufei.setUser(user);
            }
        }
        ActionContext.getContext().put("ShoufeiList", Shoufeis);


        return "onesflist";
    }

    /**
     * 修改页面
     */
    public String onesfeditUI() throws Exception {
        // 准备回显的数据
        // 准备回显的数据
        Shoufei role = shoufeiService.getById(model.getId());
        if (role != null) {
            User user = userService.getById(Long.valueOf(role.getUserid()));
            role.setUser(user);
        }
        ActionContext.getContext().getValueStack().push(role);
        return "onesfeditUI";
    }

    public String mfinfos() throws Exception {
        // 准备回显的数据
        // 准备回显的数据
        List<Mianfei> Mianfeilis = mianfeiService.findAllPass();
        for (Mianfei Mianfei : Mianfeilis) {
            if (Mianfei.getUserid() != null) {
                User user = userService.getById(Long.valueOf(Mianfei.getUserid()));
                Mianfei.setUser(user);
            } else {
                User user = new User();
                user.setName("游客");
                Mianfei.setUser(user);
            }

        }

        List<Category> categorylis = categoryService.findAll();
        ActionContext.getContext().put("CategoryList", categorylis);

        ActionContext.getContext().put("MianfeiList", Mianfeilis);
        return "mfinfos";
    }


    public String sfinfos() throws Exception {
        // 准备回显的数据
        User user = (User) ActionContext.getContext().getSession().get("user");
        if (user != null) {
            List<Shoufei> Shoufeilis = shoufeiService.findAllPass();
            for (Shoufei shoufei : Shoufeilis) {
                shoufei.setUser(user);
            }
            ActionContext.getContext().put("ShoufeiList", Shoufeilis);
        }
        List<Category> categorylis = categoryService.findAll();
        ActionContext.getContext().put("CategoryList", categorylis);

        return "sfinfos";
    }


    public String sfinfosFenlei() throws Exception {
        // 准备回显的数据
        HttpServletRequest request = ServletActionContext.getRequest();
        String strText = request.getParameter("cid");
        User user = (User) ActionContext.getContext().getSession().get("user");
        if (user != null) {
            List<Shoufei> Shoufeilis = shoufeiService.findAllPassFenlei(strText);
            for (Shoufei shoufei : Shoufeilis) {
                shoufei.setUser(user);
            }
            ActionContext.getContext().put("ShoufeiList", Shoufeilis);
        }
        List<Category> categorylis = categoryService.findAll();
        ActionContext.getContext().put("CategoryList", categorylis);

        return "sfinfos";
    }

    public String mfinfosFenlei() throws Exception {
        // 准备回显的数据
        // 准备回显的数据
        HttpServletRequest request = ServletActionContext.getRequest();
        String strText = request.getParameter("cid");
        List<Mianfei> Mianfeilis = mianfeiService.findAllPassFenlei(strText);
        for (Mianfei Mianfei : Mianfeilis) {
            if (Mianfei.getUserid() != null) {
                User user = userService.getById(Long.valueOf(Mianfei.getUserid()));
                Mianfei.setUser(user);
            } else {
                User user = new User();
                user.setName("游客");
                Mianfei.setUser(user);
            }

        }

        List<Category> categorylis = categoryService.findAll();
        ActionContext.getContext().put("CategoryList", categorylis);

        ActionContext.getContext().put("MianfeiList", Mianfeilis);
        return "mfinfos";
    }

    public String form() throws Exception {
        // 准备回显的数据
        HttpServletRequest request = ServletActionContext.getRequest();
        String strText = request.getParameter("infos");
        String value = request.getParameter("catid");
        if (value.equals("shoufei")) {
            User user = (User) ActionContext.getContext().getSession().get("user");
            if (user != null) {
                if (strText == null || strText.equals("")) {
                    List<Shoufei> Shoufeilis = shoufeiService.findMianfeis(strText);
                    ActionContext.getContext().put("ShoufeiList", Shoufeilis);
                    return "sfinfos";
                }


                List<Shoufei> Shoufeilis = shoufeiService.findAll();
                for (Shoufei shoufei : Shoufeilis) {
                    shoufei.setUser(user);
                }
                ActionContext.getContext().put("ShoufeiList", Shoufeilis);
            }

            return "sfinfos";

        } else if (value.equals("free")) {
            if (strText == null || strText.equals("")) {
                List<Mianfei> Mianfeilis = mianfeiService.findAll();
                ActionContext.getContext().put("MianfeiList", Mianfeilis);
                return "mfinfos";
            }
            List<Mianfei> Mianfeilis = mianfeiService.findMianfeis(strText);
            ActionContext.getContext().put("MianfeiList", Mianfeilis);
            return "mfinfos";
        } else {
            return "";
        }
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

}
