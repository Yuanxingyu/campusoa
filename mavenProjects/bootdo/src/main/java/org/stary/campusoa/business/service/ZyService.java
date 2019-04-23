package org.stary.campusoa.business.service;

import org.stary.campusoa.business.domain.ZyDO;

import java.util.List;
import java.util.Map;

/**
 * 专业
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
public interface ZyService {
	
	ZyDO get(Integer tid);
	
	List<ZyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZyDO zy);
	
	int update(ZyDO zy);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
