package org.stary.campusoa.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.stary.campusoa.business.dao.XsKcDao;
import org.stary.campusoa.business.domain.XsKcDO;
import org.stary.campusoa.business.service.XsKcService;



@Service
public class XsKcServiceImpl implements XsKcService {
	@Autowired
	private XsKcDao xsKcDao;
	
	@Override
	public XsKcDO get(Integer tid){
		return xsKcDao.get(tid);
	}
	
	@Override
	public List<XsKcDO> list(Map<String, Object> map){
		return xsKcDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return xsKcDao.count(map);
	}
	
	@Override
	public int save(XsKcDO xsKc){
		return xsKcDao.save(xsKc);
	}
	
	@Override
	public int update(XsKcDO xsKc){
		return xsKcDao.update(xsKc);
	}
	
	@Override
	public int remove(Integer tid){
		return xsKcDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return xsKcDao.batchRemove(tids);
	}
	
}
