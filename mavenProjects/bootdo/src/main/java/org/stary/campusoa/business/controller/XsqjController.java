package org.stary.campusoa.business.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.stary.campusoa.activiti.utils.ActivitiUtils;
import org.stary.campusoa.business.domain.XsqjDO;
import org.stary.campusoa.business.service.XsqjService;
import org.stary.campusoa.common.utils.PageUtils;
import org.stary.campusoa.common.utils.Query;
import org.stary.campusoa.common.utils.R;

/**
 * 请假事务表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-05-13 14:49:57
 */
 
@Controller
@RequestMapping("/business/xsqj")
public class XsqjController {
	@Autowired
	private XsqjService xsqjService;

	@Autowired
	ActivitiUtils activitiUtils;
	
	@GetMapping()
	@RequiresPermissions("business:xsqj:xsqj")
	String Xsqj(){
	    return "business/xsqj/xsqj";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("business:xsqj:xsqj")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<XsqjDO> xsqjList = xsqjService.list(query);
		int total = xsqjService.count(query);
		PageUtils pageUtils = new PageUtils(xsqjList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("business:xsqj:add")
	String add(){
	    return "business/xsqj/add";
	}

	@GetMapping("/edit")
	String edit() {
		return "business/xsqj/add";
	}

	@GetMapping("/edit/{tid}")
	@RequiresPermissions("business:xsqj:edit")
	String edit(@PathVariable("tid") Integer tid,Model model){
		XsqjDO xsqj = xsqjService.get(tid);
		model.addAttribute("xsqj", xsqj);
	    return "business/xsqj/edit";
	}

	@GetMapping("/form/{taskId}")
	String edit(@PathVariable("taskId") String taskId, Model model) {
		XsqjDO xsqjDO = xsqjService.get(Integer.parseInt(activitiUtils.getBusinessKeyByTaskId(taskId)));
		xsqjDO.setTaskId(taskId);
		model.addAttribute("xsqj", xsqjDO);
		return "business/xsqj/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:xsqj:add")
	public R save( XsqjDO xsqj){
		if(xsqjService.save(xsqj)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("business:xsqj:edit")
	public R update( XsqjDO xsqj){
		xsqjService.update(xsqj);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:xsqj:remove")
	public R remove( Integer tid){
		if(xsqjService.remove(tid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:xsqj:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] tids){
		xsqjService.batchRemove(tids);
		return R.ok();
	}
	
}
