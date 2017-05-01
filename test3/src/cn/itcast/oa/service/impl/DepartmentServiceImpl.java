package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.DepartmentService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {

    @Resource
    private SessionFactory sessionFactory;

    public List<Department> findTopList() {
        return sessionFactory.getCurrentSession().createQuery(//
                "FROM Department d WHERE d.parent IS NULL")//
                .list();
    }

    public List<Department> findChildren(Long parentId) {
        return sessionFactory.getCurrentSession().createQuery(//
                "FROM Department d WHERE d.parent.id=?")//
                .setParameter(0, parentId)//
                .list();
    }

    public List<Department> findDepartments(String strText) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Department where name= ?");
        query.setParameter(0, strText);
        return query.list();
    }

}
