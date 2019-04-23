package org.stary.campusoa.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.stary.campusoa.business.dao.BjKbDao;
import org.stary.campusoa.business.domain.BjKbDO;
import org.stary.campusoa.business.service.BjKbService;



@Service
public class BjKbServiceImpl implements BjKbService {
	@Autowired
	private BjKbDao bjKbDao;
	
	@Override
	public BjKbDO get(Integer tid){
		return bjKbDao.get(tid);
	}
	
	@Override
	public List<BjKbDO> list(Map<String, Object> map){
		return bjKbDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bjKbDao.count(map);
	}
	
	@Override
	public int save(BjKbDO bjKb){
		return bjKbDao.save(bjKb);
	}
	
	@Override
	public int update(BjKbDO bjKb){
		return bjKbDao.update(bjKb);
	}
	
	@Override
	public int remove(Integer tid){
		return bjKbDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return bjKbDao.batchRemove(tids);
	}
	
}
