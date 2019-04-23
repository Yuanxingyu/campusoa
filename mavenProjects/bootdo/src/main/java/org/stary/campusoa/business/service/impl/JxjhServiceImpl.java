package org.stary.campusoa.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.stary.campusoa.business.dao.JxjhDao;
import org.stary.campusoa.business.domain.JxjhDO;
import org.stary.campusoa.business.service.JxjhService;



@Service
public class JxjhServiceImpl implements JxjhService {
	@Autowired
	private JxjhDao jxjhDao;
	
	@Override
	public JxjhDO get(Integer tid){
		return jxjhDao.get(tid);
	}
	
	@Override
	public List<JxjhDO> list(Map<String, Object> map){
		return jxjhDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return jxjhDao.count(map);
	}
	
	@Override
	public int save(JxjhDO jxjh){
		return jxjhDao.save(jxjh);
	}
	
	@Override
	public int update(JxjhDO jxjh){
		return jxjhDao.update(jxjh);
	}
	
	@Override
	public int remove(Integer tid){
		return jxjhDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return jxjhDao.batchRemove(tids);
	}
	
}
