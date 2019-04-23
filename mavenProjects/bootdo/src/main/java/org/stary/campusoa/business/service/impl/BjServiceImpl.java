package org.stary.campusoa.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.stary.campusoa.business.dao.BjDao;
import org.stary.campusoa.business.domain.BjDO;
import org.stary.campusoa.business.service.BjService;



@Service
public class BjServiceImpl implements BjService {
	@Autowired
	private BjDao bjDao;
	
	@Override
	public BjDO get(Integer tid){
		return bjDao.get(tid);
	}
	
	@Override
	public List<BjDO> list(Map<String, Object> map){
		return bjDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bjDao.count(map);
	}
	
	@Override
	public int save(BjDO bj){
		return bjDao.save(bj);
	}
	
	@Override
	public int update(BjDO bj){
		return bjDao.update(bj);
	}
	
	@Override
	public int remove(Integer tid){
		return bjDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return bjDao.batchRemove(tids);
	}
	
}
