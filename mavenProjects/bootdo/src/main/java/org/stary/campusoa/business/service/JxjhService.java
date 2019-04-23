package org.stary.campusoa.business.service;

import org.stary.campusoa.business.domain.JxjhDO;

import java.util.List;
import java.util.Map;

/**
 * 教学计划表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
public interface JxjhService {
	
	JxjhDO get(Integer tid);
	
	List<JxjhDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(JxjhDO jxjh);
	
	int update(JxjhDO jxjh);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
