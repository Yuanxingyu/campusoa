package org.stary.campusoa.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.stary.campusoa.activiti.config.ActivitiConstant;
import org.stary.campusoa.activiti.service.impl.ActTaskServiceImpl;
import org.stary.campusoa.business.dao.XsqjDao;
import org.stary.campusoa.business.domain.XsqjDO;
import org.stary.campusoa.business.service.XsqjService;
import org.stary.campusoa.common.utils.ShiroUtils;


@Service
public class XsqjServiceImpl implements XsqjService {
	@Autowired
	private XsqjDao xsqjDao;

	@Autowired
	private ActTaskServiceImpl actTaskService;


	@Override
	public XsqjDO get(Integer tid){
		return xsqjDao.get(tid);
	}
	
	@Override
	public List<XsqjDO> list(Map<String, Object> map){
		return xsqjDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return xsqjDao.count(map);
	}
	
	@Override
	public int save(XsqjDO xsqj){
		xsqj.setXsid(Integer.valueOf(ShiroUtils.getUserId().toString()));
		xsqj.setXsname(ShiroUtils.getUser().getName());
		xsqj.setProcessstate("审批中");
		int result = xsqjDao.save(xsqj);
		Map map = new HashMap<>();
		//找到流程处理人并对设置的assignee进行key的设值
		//TODO 根据班级负责人信息与学生绑定的班级信息拿到辅导员id
		map.put("fdyId","139");
		actTaskService.startProcess(ActivitiConstant.ACTIVITI_XSQJ[0],ActivitiConstant.ACTIVITI_XSQJ[1],xsqj.getTid().toString(),xsqj.getQjyy(),map);
		return result;
	}
	
	@Override
	public int update(XsqjDO xsqj){
		Map<String,Object> vars = new HashMap<>(16);
		vars.put("pass",  xsqj.getTaskPass() );
		vars.put("title","");
		actTaskService.complete(xsqj.getTaskId(),vars);
		return xsqjDao.update(xsqj);
	}
	
	@Override
	public int remove(Integer tid){
		return xsqjDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return xsqjDao.batchRemove(tids);
	}
	
}
