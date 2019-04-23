package org.stary.campusoa.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.stary.campusoa.business.dao.ZyDao;
import org.stary.campusoa.business.domain.ZyDO;
import org.stary.campusoa.business.service.ZyService;



@Service
public class ZyServiceImpl implements ZyService {
	@Autowired
	private ZyDao zyDao;
	
	@Override
	public ZyDO get(Integer tid){
		return zyDao.get(tid);
	}
	
	@Override
	public List<ZyDO> list(Map<String, Object> map){
		return zyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return zyDao.count(map);
	}
	
	@Override
	public int save(ZyDO zy){
		return zyDao.save(zy);
	}
	
	@Override
	public int update(ZyDO zy){
		return zyDao.update(zy);
	}
	
	@Override
	public int remove(Integer tid){
		return zyDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return zyDao.batchRemove(tids);
	}
	
}
