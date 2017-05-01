package cn.itcast.oa.view.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Category;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Mianfei;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.util.QueryHelper;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {

    /**
     * 列表
     */
    public String list() throws Exception {
        List<Category> categorylis = categoryService.findAll();
        ActionContext.getContext().put("CategoryList", categorylis);

        return "list";
    }

    /**
     * 删除
     */
    public String delete() throws Exception {
        categoryService.delete(model.getId());
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
        categoryService.save(model);
        return "toList";
    }

    /**
     * 修改页面
     */
    public String editUI() throws Exception {
        // 准备回显的数据
        Category role = categoryService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(role);

        return "editUI";
    }

    /**
     * 修改
     */
    public String edit() throws Exception {
        // 1，从数据库中获取原对象
        Category role = categoryService.getById(model.getId());
        role.setName(model.getName());

        // 3，更新到数据库
        categoryService.update(role);

        return "toList";
    }

    public String select() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String strText = request.getParameter("strText");
        if (strText == null || strText.equals("")) {
            return "toList";
        }
        List<Category> categorylis = categoryService.findMianfeis(strText);
        ActionContext.getContext().put("CategoryList", categorylis);
        ActionContext.getContext().put("strText", strText);
        return "list";
    }
}
