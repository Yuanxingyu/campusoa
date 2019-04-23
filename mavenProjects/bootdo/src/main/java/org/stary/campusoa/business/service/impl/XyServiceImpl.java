package org.stary.campusoa.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.stary.campusoa.business.dao.XyDao;
import org.stary.campusoa.business.domain.XyDO;
import org.stary.campusoa.business.service.XyService;



@Service
public class XyServiceImpl implements XyService {
	@Autowired
	private XyDao xyDao;
	
	@Override
	public XyDO get(Integer tid){
		return xyDao.get(tid);
	}
	
	@Override
	public List<XyDO> list(Map<String, Object> map){
		return xyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return xyDao.count(map);
	}
	
	@Override
	public int save(XyDO xy){
		return xyDao.save(xy);
	}
	
	@Override
	public int update(XyDO xy){
		return xyDao.update(xy);
	}
	
	@Override
	public int remove(Integer tid){
		return xyDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return xyDao.batchRemove(tids);
	}
	
}
