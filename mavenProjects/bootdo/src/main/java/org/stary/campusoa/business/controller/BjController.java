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

import org.stary.campusoa.business.domain.BjDO;
import org.stary.campusoa.business.service.BjService;
import org.stary.campusoa.common.utils.PageUtils;
import org.stary.campusoa.common.utils.Query;
import org.stary.campusoa.common.utils.R;

/**
 * 班级表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
 
@Controller
@RequestMapping("/business/bj")
public class BjController {
	@Autowired
	private BjService bjService;
	
	@GetMapping()
	@RequiresPermissions("business:bj:bj")
	String Bj(){
	    return "business/bj/bj";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("business:bj:bj")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BjDO> bjList = bjService.list(query);
		int total = bjService.count(query);
		PageUtils pageUtils = new PageUtils(bjList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("business:bj:add")
	String add(){
	    return "business/bj/add";
	}

	@GetMapping("/edit/{tid}")
	@RequiresPermissions("business:bj:edit")
	String edit(@PathVariable("tid") Integer tid,Model model){
		BjDO bj = bjService.get(tid);
		model.addAttribute("bj", bj);
	    return "business/bj/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:bj:add")
	public R save( BjDO bj){
		if(bjService.save(bj)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("business:bj:edit")
	public R update( BjDO bj){
		bjService.update(bj);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:bj:remove")
	public R remove( Integer tid){
		if(bjService.remove(tid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:bj:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] tids){
		bjService.batchRemove(tids);
		return R.ok();
	}
	
}
