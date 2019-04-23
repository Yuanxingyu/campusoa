package org.stary.campusoa.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.stary.campusoa.business.dao.TeacherDao;
import org.stary.campusoa.business.domain.TeacherDO;
import org.stary.campusoa.business.service.TeacherService;



@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;
	
	@Override
	public TeacherDO get(Integer tid){
		return teacherDao.get(tid);
	}
	
	@Override
	public List<TeacherDO> list(Map<String, Object> map){
		return teacherDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return teacherDao.count(map);
	}
	
	@Override
	public int save(TeacherDO teacher){
		return teacherDao.save(teacher);
	}
	
	@Override
	public int update(TeacherDO teacher){
		return teacherDao.update(teacher);
	}
	
	@Override
	public int remove(Integer tid){
		return teacherDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return teacherDao.batchRemove(tids);
	}
	
}
