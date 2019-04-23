package org.stary.campusoa.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.stary.campusoa.business.dao.ZyKcDao;
import org.stary.campusoa.business.domain.ZyKcDO;
import org.stary.campusoa.business.service.ZyKcService;



@Service
public class ZyKcServiceImpl implements ZyKcService {
	@Autowired
	private ZyKcDao zyKcDao;
	
	@Override
	public ZyKcDO get(Integer tid){
		return zyKcDao.get(tid);
	}
	
	@Override
	public List<ZyKcDO> list(Map<String, Object> map){
		return zyKcDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return zyKcDao.count(map);
	}
	
	@Override
	public int save(ZyKcDO zyKc){
		return zyKcDao.save(zyKc);
	}
	
	@Override
	public int update(ZyKcDO zyKc){
		return zyKcDao.update(zyKc);
	}
	
	@Override
	public int remove(Integer tid){
		return zyKcDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return zyKcDao.batchRemove(tids);
	}
	
}
