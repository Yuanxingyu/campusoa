package org.stary.campusoa.business.service;

import org.stary.campusoa.business.domain.XsKcDO;

import java.util.List;
import java.util.Map;

/**
 * 学生选课表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
public interface XsKcService {
	
	XsKcDO get(Integer tid);
	
	List<XsKcDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(XsKcDO xsKc);
	
	int update(XsKcDO xsKc);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
