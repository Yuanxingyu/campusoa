package org.stary.campusoa.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.stary.campusoa.business.dao.StudentDao;
import org.stary.campusoa.business.domain.StudentDO;
import org.stary.campusoa.business.service.StudentService;



@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public StudentDO get(Integer tid){
		return studentDao.get(tid);
	}
	
	@Override
	public List<StudentDO> list(Map<String, Object> map){
		return studentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return studentDao.count(map);
	}
	
	@Override
	public int save(StudentDO student){
		return studentDao.save(student);
	}
	
	@Override
	public int update(StudentDO student){
		return studentDao.update(student);
	}
	
	@Override
	public int remove(Integer tid){
		return studentDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return studentDao.batchRemove(tids);
	}
	
}
