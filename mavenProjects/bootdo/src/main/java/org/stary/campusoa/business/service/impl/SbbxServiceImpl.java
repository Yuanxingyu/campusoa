package org.stary.campusoa.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.stary.campusoa.activiti.config.ActivitiConstant;
import org.stary.campusoa.activiti.service.ActTaskService;
import org.stary.campusoa.business.dao.SbbxDao;
import org.stary.campusoa.business.domain.SbbxDO;
import org.stary.campusoa.business.service.SbbxService;
import org.stary.campusoa.common.utils.ShiroUtils;


@Service
public class SbbxServiceImpl implements SbbxService {
	@Autowired
	private SbbxDao sbbxDao;

	@Autowired
	private ActTaskService actTaskService;
	
	@Override
	public SbbxDO get(Integer tid){
		return sbbxDao.get(tid);
	}
	
	@Override
	public List<SbbxDO> list(Map<String, Object> map){
		return sbbxDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sbbxDao.count(map);
	}
	
	@Override
	public int save(SbbxDO sbbx){
		sbbx.setXsid(Integer.valueOf(ShiroUtils.getUserId().toString()));
		sbbx.setXsname(ShiroUtils.getUser().getName());
		sbbx.setProcessstate("审批中");
		int result = sbbxDao.save(sbbx);
		Map map = new HashMap<>();
		//找到流程处理人并对设置的assignee进行key的设值
		//TODO 根据班级负责人信息与学生绑定的班级信息拿到辅导员id
		map.put("fdyId","139");
		actTaskService.startProcess(ActivitiConstant.ACTIVITI_SBBX[0],ActivitiConstant.ACTIVITI_SBBX[1],sbbx.getTid().toString(),sbbx.getQjyy(),map);
		return result;
	}
	
	@Override
	public int update(SbbxDO sbbx){
		Map<String,Object> vars = new HashMap<>(16);
		vars.put("pass",  sbbx.getTaskPass() );
		vars.put("title","");
		actTaskService.complete(sbbx.getTaskId(),vars);
		return sbbxDao.update(sbbx);
	}
	
	@Override
	public int remove(Integer tid){
		return sbbxDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return sbbxDao.batchRemove(tids);
	}
	
}
