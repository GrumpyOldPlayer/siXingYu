package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Mianfei;
import cn.itcast.oa.domain.Shoufei;

public interface MianfeiService extends DaoSupport<Mianfei> {

    List<Mianfei> userID(Long id);

    List<Mianfei> findMianfeis(String strText);

    List<Mianfei> findAllPass();

    List<Mianfei> findAllPassFenlei(String strText);

    List<Mianfei> findMianfeisByCategories(String categories);
}
