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

import org.stary.campusoa.business.domain.XsKcDO;
import org.stary.campusoa.business.service.XsKcService;
import org.stary.campusoa.common.utils.PageUtils;
import org.stary.campusoa.common.utils.Query;
import org.stary.campusoa.common.utils.R;

/**
 * 学生选课表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
 
@Controller
@RequestMapping("/business/xsKc")
public class XsKcController {
	@Autowired
	private XsKcService xsKcService;
	
	@GetMapping()
	@RequiresPermissions("business:xsKc:xsKc")
	String XsKc(){
	    return "business/xsKc/xsKc";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("business:xsKc:xsKc")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<XsKcDO> xsKcList = xsKcService.list(query);
		int total = xsKcService.count(query);
		PageUtils pageUtils = new PageUtils(xsKcList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("business:xsKc:add")
	String add(){
	    return "business/xsKc/add";
	}

	@GetMapping("/edit/{tid}")
	@RequiresPermissions("business:xsKc:edit")
	String edit(@PathVariable("tid") Integer tid,Model model){
		XsKcDO xsKc = xsKcService.get(tid);
		model.addAttribute("xsKc", xsKc);
	    return "business/xsKc/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:xsKc:add")
	public R save( XsKcDO xsKc){
		if(xsKcService.save(xsKc)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("business:xsKc:edit")
	public R update( XsKcDO xsKc){
		xsKcService.update(xsKc);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:xsKc:remove")
	public R remove( Integer tid){
		if(xsKcService.remove(tid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:xsKc:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] tids){
		xsKcService.batchRemove(tids);
		return R.ok();
	}
	
}
