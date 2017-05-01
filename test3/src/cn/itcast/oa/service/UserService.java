package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.User;

public interface UserService extends DaoSupport<User> {

    /**
     * 根据登录名与密码查询用户
     *
     * @param loginName
     * @param password  明文密码
     * @return
     */
    User findByLoginNameAndPassword(String loginName, String password);

    List<User> findUsers(String strText);

}
