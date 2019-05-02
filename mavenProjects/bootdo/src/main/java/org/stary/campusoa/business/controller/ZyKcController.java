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

import org.stary.campusoa.business.domain.ZyKcDO;
import org.stary.campusoa.business.service.ZyKcService;
import org.stary.campusoa.common.utils.PageUtils;
import org.stary.campusoa.common.utils.Query;
import org.stary.campusoa.common.utils.R;

/**
 * 专业-课程联系表（定义各专业的开课课程，用来做各个专业的教学计划）
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
 
@Controller
@RequestMapping("/business/zyKc")
public class ZyKcController {
	@Autowired
	private ZyKcService zyKcService;
	
	@GetMapping()
	@RequiresPermissions("business:zyKc:zyKc")
	String ZyKc(){
	    return "business/zyKc/zyKc";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("business:zyKc:zyKc")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ZyKcDO> zyKcList = zyKcService.list(query);
		int total = zyKcService.count(query);
		PageUtils pageUtils = new PageUtils(zyKcList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("business:zyKc:add")
	String add(){
	    return "business/zyKc/add";
	}

	@GetMapping("/edit/{tid}")
	@RequiresPermissions("business:zyKc:edit")
	String edit(@PathVariable("tid") Integer tid,Model model){
		ZyKcDO zyKc = zyKcService.get(tid);
		model.addAttribute("zyKc", zyKc);
	    return "business/zyKc/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:zyKc:add")
	public R save( ZyKcDO zyKc){
		if(zyKcService.save(zyKc)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("business:zyKc:edit")
	public R update( ZyKcDO zyKc){
		zyKcService.update(zyKc);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:zyKc:remove")
	public R remove( Integer tid){
		if(zyKcService.remove(tid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:zyKc:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] tids){
		zyKcService.batchRemove(tids);
		return R.ok();
	}

	/**
	 * 查找
	 */
	@GetMapping( "/queryByproperties")
	@ResponseBody
	@RequiresPermissions("business:zyKc:zyKc")
	public List<ZyKcDO> queryByproperties(@RequestParam Map<String, Object> params){
		return zyKcService.list(params);
	}

}
