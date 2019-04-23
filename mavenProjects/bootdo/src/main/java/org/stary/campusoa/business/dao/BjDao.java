package org.stary.campusoa.business.dao;

import org.stary.campusoa.business.domain.BjDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 班级表
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
@Mapper
public interface BjDao {

	BjDO get(Integer tid);
	
	List<BjDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BjDO bj);
	
	int update(BjDO bj);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
