package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Category;
import cn.itcast.oa.service.CategoryService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class CategoryServiceImpl extends DaoSupportImpl<Category> implements CategoryService {
    @Resource
    private SessionFactory sessionFactory;

    public List<Category> findMianfeis(String strText) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Category where name= ?");
        query.setParameter(0, strText);
        return query.list();
    }

}
