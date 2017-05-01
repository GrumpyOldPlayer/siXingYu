package cn.itcast.oa.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {

    public User findByLoginNameAndPassword(String loginName, String password) {
        // 使用密码的MD5摘要进行对比
        String md5Digest = DigestUtils.md5Hex(password);
        return (User) getSession().createQuery(//
                "FROM User u WHERE u.loginName=? AND u.password=?")//
                .setParameter(0, loginName)//
                .setParameter(1, md5Digest)//
                .uniqueResult();
    }

    public List<User> findUsers(String strText) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.or(Restrictions.eq("loginName", strText), Restrictions.or(Restrictions.eq("name", strText), Restrictions.eq("phoneNumber", strText))));
        return criteria.list();
    }

}
