package cn.itcast.oa.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Category;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {

    public List<Role> findRoles(String strText) {
        Criteria criteria = getSession().createCriteria(Role.class);
        criteria.add(Restrictions.eq("name", strText));
        return criteria.list();
    }

    // @Resource
    // private RoleDao roleDao;
    //
    // public Role getById(Long id) {
    // return roleDao.getById(id);
    // }
    //
    // public void delete(Long id) {
    // roleDao.delete(id);
    // }
    //
    // public void save(Role role) {
    // roleDao.save(role);
    // }
    //
    // public void update(Role role) {
    // roleDao.update(role);
    // }
    //
    // public List<Role> findAll() {
    // return roleDao.findAll();
    // }

}
