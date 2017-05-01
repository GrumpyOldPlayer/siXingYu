package cn.itcast.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Infos;
import cn.itcast.oa.service.InfosService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class InfosServiceImpl extends DaoSupportImpl<Infos> implements InfosService {

}
