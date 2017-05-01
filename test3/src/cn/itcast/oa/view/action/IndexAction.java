package cn.itcast.oa.view.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Category;
import cn.itcast.oa.domain.Infos;
import cn.itcast.oa.domain.Mianfei;
import cn.itcast.oa.domain.Shoufei;
import cn.itcast.oa.domain.User;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class IndexAction extends BaseAction<Category> {

    /**
     * 列表
     */
    public String index() throws Exception {
        User user = (User) ActionContext.getContext().getSession().get("user");
        if (user != null) {
            List<Shoufei> slist = shoufeiService.findAllPass();
            if (slist.size() > 5) {
                List<Shoufei> slists = new ArrayList();
                for (int i = 0; i < 5; i++) {
                    slists.add(slist.get(i));
                }
                ActionContext.getContext().put("slist", slists);
            } else {
                ActionContext.getContext().put("slist", slist);
            }

        }

        List<Mianfei> Mianfeilis = mianfeiService.findAllPass();

        if (Mianfeilis.size() > 5) {
            List<Mianfei> Mianfeilist = new ArrayList();
            for (int i = 0; i < 5; i++) {
                Mianfeilist.add(Mianfeilis.get(i));
            }
            ActionContext.getContext().put("MianfeiList", Mianfeilist);
        } else {
            ActionContext.getContext().put("MianfeiList", Mianfeilis);
        }


        return "index";
    }


}
