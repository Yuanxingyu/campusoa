package org.stary.campusoa.business.service;

import org.stary.campusoa.business.domain.StudentDO;

import java.util.List;
import java.util.Map;

/**
 * 学生表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
public interface StudentService {
	
	StudentDO get(Integer tid);
	
	List<StudentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(StudentDO student);
	
	int update(StudentDO student);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
