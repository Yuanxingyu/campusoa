package org.stary.campusoa.business.service;

import org.stary.campusoa.business.domain.XsqjDO;

import java.util.List;
import java.util.Map;

/**
 * 请假事务表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-05-13 14:49:57
 */
public interface XsqjService {
	
	XsqjDO get(Integer tid);
	
	List<XsqjDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(XsqjDO xsqj);
	
	int update(XsqjDO xsqj);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
