package org.stary.campusoa.business.dao;

import org.stary.campusoa.business.domain.JxjhDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 教学计划表
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
@Mapper
public interface JxjhDao {

	JxjhDO get(Integer tid);
	
	List<JxjhDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(JxjhDO jxjh);
	
	int update(JxjhDO jxjh);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
