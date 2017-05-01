package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Category;

public interface CategoryService extends DaoSupport<Category> {

    List<Category> findMianfeis(String strText);

}
