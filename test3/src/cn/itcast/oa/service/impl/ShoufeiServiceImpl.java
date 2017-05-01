package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Mianfei;
import cn.itcast.oa.domain.Shoufei;
import cn.itcast.oa.service.ShoufeiService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class ShoufeiServiceImpl extends DaoSupportImpl<Shoufei> implements ShoufeiService {
    @Resource
    private SessionFactory sessionFactory;

    public List<Shoufei> userID(Long id) {

        Criteria criteria = getSession().createCriteria(Shoufei.class);
        criteria.add(Restrictions.eq("userid", id.toString()));
        return criteria.list();
    }

    public List<Shoufei> findMianfeis(String strText) {
        Criteria criteria = getSession().createCriteria(Shoufei.class);
        criteria.add(Restrictions.or(Restrictions.like("title", "%" + strText + "%"), Restrictions.like("text", "%" + strText + "%")));
        return criteria.list();
    }

    @Override
    public List<Shoufei> findMianfeisByCategories(String categories) {
        Criteria criteria = getSession().createCriteria(Shoufei.class);
        criteria.add(Restrictions.eq("cid", Long.parseLong(categories)));
        return criteria.list();
    }

    public List<Shoufei> findAllPass() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Shoufei where state= ?");
        query.setParameter(0, "确认");
        return query.list();
    }

    public List<Shoufei> findAllPassFenlei(String strText) {
        Criteria criteria = getSession().createCriteria(Shoufei.class);
        criteria.add(Restrictions.eq("cid", Long.valueOf(strText)));
        criteria.add(Restrictions.eq("state", "确认"));
        return criteria.list();
    }
}
