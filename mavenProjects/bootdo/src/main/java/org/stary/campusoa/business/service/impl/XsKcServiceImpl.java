package org.stary.campusoa.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.stary.campusoa.business.dao.StudentDao;
import org.stary.campusoa.business.dao.XsKcDao;
import org.stary.campusoa.business.domain.StudentDO;
import org.stary.campusoa.business.domain.XsKcDO;
import org.stary.campusoa.business.service.XsKcService;
import org.stary.campusoa.common.utils.ShiroUtils;


@Service
public class XsKcServiceImpl implements XsKcService {
	@Autowired
	private XsKcDao xsKcDao;

	@Autowired
	private StudentDao studentDao;

	@Override
	public XsKcDO get(Integer tid){
		return xsKcDao.get(tid);
	}
	
	@Override
	public List<XsKcDO> list(Map<String, Object> map){
		return xsKcDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return xsKcDao.count(map);
	}
	
	@Override
	public int save(String[] kcIds){
		int flag = 0;
		for (String id : kcIds){
			XsKcDO xsKcDO = new XsKcDO();
			xsKcDO.setXsid(getStuByUserId().getTid());
			xsKcDO.setZykcid(Integer.parseInt(id));
			flag = xsKcDao.save(xsKcDO);
			if (flag <= 0){
				break;
			}
		}
		return flag;
	}
	
	@Override
	public int update(XsKcDO xsKc){
		return xsKcDao.update(xsKc);
	}
	
	@Override
	public int remove(Integer tid){
		return xsKcDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return xsKcDao.batchRemove(tids);
	}

	public StudentDO getStuByUserId(){
		Map<String,Object> map = new HashMap();
		map.put("userid",ShiroUtils.getUserId());
		StudentDO result = studentDao.list(map).get(0);
		return result;
	}
}
