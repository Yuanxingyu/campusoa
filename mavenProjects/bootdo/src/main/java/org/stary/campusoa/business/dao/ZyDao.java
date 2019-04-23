package org.stary.campusoa.business.dao;

import org.stary.campusoa.business.domain.ZyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 专业
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
@Mapper
public interface ZyDao {

	ZyDO get(Integer tid);
	
	List<ZyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZyDO zy);
	
	int update(ZyDO zy);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
