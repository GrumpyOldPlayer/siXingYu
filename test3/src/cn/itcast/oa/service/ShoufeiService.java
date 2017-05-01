package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Shoufei;

public interface ShoufeiService extends DaoSupport<Shoufei> {

    List<Shoufei> userID(Long id);

    List<Shoufei> findMianfeis(String strText);

    List<Shoufei> findMianfeisByCategories(String categories);

    List<Shoufei> findAllPass();

    List<Shoufei> findAllPassFenlei(String strText);

}
