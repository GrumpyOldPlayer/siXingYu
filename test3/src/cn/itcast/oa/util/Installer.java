package cn.itcast.oa.util;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.User;

@Component
public class Installer {

    @Resource
    private SessionFactory sessionFactory;

    /**
     * 执行安装
     */
    @Transactional
    public void install() {
        Session session = sessionFactory.getCurrentSession();

        // ==============================================================
        // 保存超级管理员用户
        User user = new User();
        user.setLoginName("admin");
        user.setName("超级管理员");
        user.setPassword(DigestUtils.md5Hex("admin"));
        session.save(user); // 保存

        // ==============================================================
        // 保存权限数据
        Privilege menu, menu1, menu2, menu3, menu4, menu5, menu6;

        // --------------------
        menu = new Privilege("系统管理", null, null);
        menu1 = new Privilege("岗位管理", "/role_list", menu);
        menu2 = new Privilege("部门管理", "/department_list", menu);
        menu3 = new Privilege("用户管理", "/user_list", menu);
        menu4 = new Privilege("类别管理", "/ct_list", menu);

        session.save(menu);
        session.save(menu1);
        session.save(menu2);
        session.save(menu3);
        session.save(menu4);

        session.save(new Privilege("岗位列表", "/role_list", menu1));
        session.save(new Privilege("岗位删除", "/role_delete", menu1));
        session.save(new Privilege("岗位添加", "/role_add", menu1));
        session.save(new Privilege("岗位修改", "/role_edit", menu1));

        session.save(new Privilege("部门列表", "/department_list", menu2));
        session.save(new Privilege("部门删除", "/department_delete", menu2));
        session.save(new Privilege("部门添加", "/department_add", menu2));
        session.save(new Privilege("部门修改", "/department_edit", menu2));

        session.save(new Privilege("用户列表", "/user_list", menu3));
        session.save(new Privilege("用户删除", "/user_delete", menu3));
        session.save(new Privilege("用户添加", "/user_add", menu3));
        session.save(new Privilege("用户修改", "/user_edit", menu3));
        session.save(new Privilege("初始化密码", "/user_initPassword", menu3));

        session.save(new Privilege("类别列表", "/ct_list", menu4));
        session.save(new Privilege("类别删除", "/ct_delete", menu4));
        session.save(new Privilege("类别添加", "/ct_add", menu4));
        session.save(new Privilege("类别修改", "/ct_edit", menu4));

        menu = new Privilege("信息管理", null, null);
        menu5 = new Privilege("信息管理", "/infos_list", menu);
        menu6 = new Privilege("类别管理", "/sf_list", menu);

        session.save(menu);
        session.save(menu5);
        session.save(menu6);
//

        session.save(new Privilege("信息列表", "/infos_list", menu5));
        session.save(new Privilege("信息删除", "/infos_delete", menu5));
        session.save(new Privilege("信息添加", "/infos_add", menu5));
        session.save(new Privilege("信息修改", "/infos_edit", menu5));


        session.save(new Privilege("收费列表", "/sf_list", menu6));
        session.save(new Privilege("收费删除", "/sf_delete", menu6));
        session.save(new Privilege("收费添加", "/sf_add", menu6));
        session.save(new Privilege("收费修改", "/sf_edit", menu6));

        // --------------------
//		menu = new Privilege("网上交流", null, null);
//		menu1 = new Privilege("论坛管理", "/forumManage_list", menu);
//		menu2 = new Privilege("论坛", "/forum_list", menu);
//		session.save(menu);
//		session.save(menu1);
//		session.save(menu2);
//
//		// --------------------
//		menu = new Privilege("审批流转", null, null);
//		menu1 = new Privilege("审批流程管理", "/processDefinition_list", menu);
//		menu2 = new Privilege("申请模板管理", "/template_list", menu);
//		menu3 = new Privilege("起草申请", "/flow_templateList", menu);
//		menu4 = new Privilege("待我审批", "/flow_myTaskList", menu);
//		menu5 = new Privilege("我的申请查询", "/flow_myApplicationList", menu);
//		session.save(menu);
//		session.save(menu1);
//		session.save(menu2);
//		session.save(menu3);
//		session.save(menu4);
//		session.save(menu5);
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Installer installer = (Installer) ac.getBean("installer");
        installer.install();
    }
}
