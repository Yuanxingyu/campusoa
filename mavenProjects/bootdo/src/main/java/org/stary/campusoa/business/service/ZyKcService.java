package org.stary.campusoa.business.service;

import org.stary.campusoa.business.domain.ZyKcDO;

import java.util.List;
import java.util.Map;

/**
 * 专业-课程联系表（定义各专业的开课课程，用来做各个专业的教学计划）
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
public interface ZyKcService {
	
	ZyKcDO get(Integer tid);
	
	List<ZyKcDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZyKcDO zyKc);
	
	int update(ZyKcDO zyKc);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
