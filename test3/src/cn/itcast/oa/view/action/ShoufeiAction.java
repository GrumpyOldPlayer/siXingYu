package cn.itcast.oa.view.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Category;
import cn.itcast.oa.domain.Mianfei;
import cn.itcast.oa.domain.Shoufei;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.util.QueryHelper;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ShoufeiAction extends BaseAction<Shoufei> {

    /**
     * 列表
     */
    public String list() throws Exception {
        List<Category> categories = categoryService.findAll();
        List<Shoufei> Shoufeilis = shoufeiService.findAll();
        for (Shoufei shoufei : Shoufeilis) {
            User user = userService.getById(Long.valueOf(shoufei.getUserid()));
            shoufei.setUser(user);

            if (shoufei.getCid() > 0) {
                Category category = categoryService.getById(shoufei.getCid());
                if (category != null) {
                    shoufei.setCname(category.getName());
                }
            }
        }
        ActionContext.getContext().put("categories", categories);
        ActionContext.getContext().put("ShoufeiList", Shoufeilis);

        return "list";
    }

    /**
     * 删除
     */
    public String delete() throws Exception {
        shoufeiService.delete(model.getId());
        return "toList";
    }

    /**
     * 删除
     */
    public String refuse() throws Exception {
        Shoufei role = shoufeiService.getById(model.getId());
        role.setState("驳回");
        shoufeiService.update(role);
        return "toList";
    }


    /**
     * 删除
     */
    public String confirm() throws Exception {
        Shoufei role = shoufeiService.getById(model.getId());
        role.setState("确认");
        shoufeiService.update(role);
        return "toList";
    }

    /**
     * 添加页面
     */
    public String addUI() throws Exception {
//		List<Infos> plist=infosService.findAll();
//		ActionContext.getContext().put("plist", plist);
        List<Category> categorylis = categoryService.findAll();
        ActionContext.getContext().put("CategoryList", categorylis);
        return "saveUI";
    }

    /**
     * 添加
     */
    public String add() throws Exception {
//		Category ct= categoryService.getById(model.getCid());
//		model.setCategory(ct.getName());
        Date dt = new Date();
        SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = matter1.format(dt);
        model.setAddtime(date);
        model.setState("申请中");
        shoufeiService.save(model);
        return "toList";
    }

    /**
     * 修改页面
     */
    public String editUI() throws Exception {
        // 准备回显的数据
        Shoufei role = shoufeiService.getById(model.getId());

        List<Category> categorylis = categoryService.findAll();
        ActionContext.getContext().put("CategoryList", categorylis);
        if (role != null) {
            User user = userService.getById(Long.valueOf(role.getUserid()));
            role.setUser(user);

            if (role.getCid() > 0) {
                Category category = categoryService.getById(role.getCid());
                if (category != null) {
                    ActionContext.getContext().put("ct", category);
                }

            }
        }
        ActionContext.getContext().getValueStack().push(role);
        return "editUI";
    }

    /**
     * 修改
     */
    public String edit() throws Exception {
        // 1，从数据库中获取原对象
        Shoufei role = shoufeiService.getById(model.getId());
//		role.setState(state)
        role.setTel(model.getTel());
        role.setTitle(model.getTitle());
//		role.setPrice(model.getPrice());
        role.setText(model.getText());
        // 3，更新到数据库
        shoufeiService.update(role);
        return "toList";
    }

    /**
     * 名称查找
     *
     * @return
     * @throws Exception
     */
    public String select() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String strText = request.getParameter("strText");
        if (strText == null || strText.equals("")) {
            return "toList";
        }
        List<Shoufei> Shoufeilis = shoufeiService.findMianfeis(strText);
        for (Shoufei shoufei : Shoufeilis) {
            User user = userService.getById(Long.valueOf(shoufei.getUserid()));
            shoufei.setUser(user);

            if (shoufei.getCid() > 0) {
                Category category = categoryService.getById(shoufei.getCid());
                if (category != null) {
                    shoufei.setCname(category.getName());
                }
            }
        }
        ActionContext.getContext().put("ShoufeiList", Shoufeilis);
        return "list";
    }

    /**
     * 分类查找
     *
     * @return
     * @throws Exception
     */
    public String selectCategories() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String categories = request.getParameter("categories").toString();
        if (categories == null || categories.equals("")) {
            return "toList";
        }
        List<Shoufei> Shoufeilis = shoufeiService.findMianfeisByCategories(categories);
        for (Shoufei shoufei : Shoufeilis) {
            User user = userService.getById(Long.valueOf(shoufei.getUserid()));
            shoufei.setUser(user);

            if (shoufei.getCid() > 0) {
                Category category = categoryService.getById(shoufei.getCid());
                if (category != null) {
                    shoufei.setCname(category.getName());
                }
            }
        }
        List<Category> categories1 = categoryService.findAll();
        ActionContext.getContext().put("categories", categories1);
        ActionContext.getContext().put("ShoufeiList", Shoufeilis);
        return "list";
    }
}
