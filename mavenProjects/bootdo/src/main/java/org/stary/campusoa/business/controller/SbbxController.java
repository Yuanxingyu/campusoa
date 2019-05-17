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
import org.stary.campusoa.business.domain.SbbxDO;
import org.stary.campusoa.business.service.SbbxService;
import org.stary.campusoa.common.utils.PageUtils;
import org.stary.campusoa.common.utils.Query;
import org.stary.campusoa.common.utils.R;

/**
 * 设备报修事务表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-05-13 14:49:57
 */
 
@Controller
@RequestMapping("/business/sbbx")
public class SbbxController {
	@Autowired
	private SbbxService sbbxService;

	@Autowired
	ActivitiUtils activitiUtils;
	
	@GetMapping()
	@RequiresPermissions("business:sbbx:sbbx")
	String Sbbx(){
	    return "business/sbbx/sbbx";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("business:sbbx:sbbx")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SbbxDO> sbbxList = sbbxService.list(query);
		int total = sbbxService.count(query);
		PageUtils pageUtils = new PageUtils(sbbxList, total);
		return pageUtils;
	}

	@GetMapping("/form/{taskId}")
	String edit(@PathVariable("taskId") String taskId, Model model) {
		SbbxDO sbbxDO = sbbxService.get(Integer.parseInt(activitiUtils.getBusinessKeyByTaskId(taskId)));
		sbbxDO.setTaskId(taskId);
		model.addAttribute("sbbx", sbbxDO);
		return "business/sbbx/edit";
	}
	
	@GetMapping("/add")
	@RequiresPermissions("business:sbbx:add")
	String add(){
	    return "business/sbbx/add";
	}

	@GetMapping("/edit")
	String edit() {
		return "business/sbbx/add";
	}

	@GetMapping("/edit/{tid}")
	@RequiresPermissions("business:sbbx:edit")
	String edit(@PathVariable("tid") Integer tid,Model model){
		SbbxDO sbbx = sbbxService.get(tid);
		model.addAttribute("sbbx", sbbx);
	    return "business/sbbx/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:sbbx:add")
	public R save( SbbxDO sbbx){
		if(sbbxService.save(sbbx)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("business:sbbx:edit")
	public R update( SbbxDO sbbx){
		sbbxService.update(sbbx);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:sbbx:remove")
	public R remove( Integer tid){
		if(sbbxService.remove(tid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:sbbx:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] tids){
		sbbxService.batchRemove(tids);
		return R.ok();
	}
	
}
