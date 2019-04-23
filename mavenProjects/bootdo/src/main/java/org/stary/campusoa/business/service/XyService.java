package org.stary.campusoa.business.service;

import org.stary.campusoa.business.domain.XyDO;

import java.util.List;
import java.util.Map;

/**
 * 学院信息
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
public interface XyService {
	
	XyDO get(Integer tid);
	
	List<XyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(XyDO xy);
	
	int update(XyDO xy);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
