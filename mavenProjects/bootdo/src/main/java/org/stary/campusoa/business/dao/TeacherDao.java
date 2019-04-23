package org.stary.campusoa.business.dao;

import org.stary.campusoa.business.domain.TeacherDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 教师表
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
@Mapper
public interface TeacherDao {

	TeacherDO get(Integer tid);
	
	List<TeacherDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TeacherDO teacher);
	
	int update(TeacherDO teacher);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
