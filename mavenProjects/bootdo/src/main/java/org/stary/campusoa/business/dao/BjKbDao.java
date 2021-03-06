package org.stary.campusoa.business.dao;

import org.stary.campusoa.business.domain.BjKbDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 班级统一课表
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
@Mapper
public interface BjKbDao {

	BjKbDO get(Integer tid);
	
	List<BjKbDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BjKbDO bjKb);
	
	int update(BjKbDO bjKb);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
