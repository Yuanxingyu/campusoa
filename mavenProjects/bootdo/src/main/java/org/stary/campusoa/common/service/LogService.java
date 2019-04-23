package org.stary.campusoa.common.service;


import org.springframework.stereotype.Service;

import org.stary.campusoa.common.domain.LogDO;
import org.stary.campusoa.common.domain.PageDO;
import org.stary.campusoa.common.utils.Query;

@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
