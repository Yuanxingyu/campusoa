package org.stary.campusoa.business.dao;

import org.stary.campusoa.business.domain.XyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 学院信息
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
@Mapper
public interface XyDao {

	XyDO get(Integer tid);
	
	List<XyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(XyDO xy);
	
	int update(XyDO xy);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
