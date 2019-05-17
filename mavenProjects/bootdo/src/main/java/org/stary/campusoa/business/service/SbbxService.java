package org.stary.campusoa.business.service;

import org.stary.campusoa.business.domain.SbbxDO;

import java.util.List;
import java.util.Map;

/**
 * 设备报修事务表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-05-13 14:49:57
 */
public interface SbbxService {
	
	SbbxDO get(Integer tid);
	
	List<SbbxDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SbbxDO sbbx);
	
	int update(SbbxDO sbbx);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
