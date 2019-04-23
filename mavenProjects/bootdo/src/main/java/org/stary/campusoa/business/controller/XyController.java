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

import org.stary.campusoa.business.domain.XyDO;
import org.stary.campusoa.business.service.XyService;
import org.stary.campusoa.common.utils.PageUtils;
import org.stary.campusoa.common.utils.Query;
import org.stary.campusoa.common.utils.R;

/**
 * 学院信息
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
 
@Controller
@RequestMapping("/business/xy")
public class XyController {
	@Autowired
	private XyService xyService;
	
	@GetMapping()
	@RequiresPermissions("business:xy:xy")
	String Xy(){
	    return "business/xy/xy";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("business:xy:xy")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<XyDO> xyList = xyService.list(query);
		int total = xyService.count(query);
		PageUtils pageUtils = new PageUtils(xyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("business:xy:add")
	String add(){
	    return "business/xy/add";
	}

	@GetMapping("/edit/{tid}")
	@RequiresPermissions("business:xy:edit")
	String edit(@PathVariable("tid") Integer tid,Model model){
		XyDO xy = xyService.get(tid);
		model.addAttribute("xy", xy);
	    return "business/xy/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:xy:add")
	public R save( XyDO xy){
		if(xyService.save(xy)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("business:xy:edit")
	public R update( XyDO xy){
		xyService.update(xy);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:xy:remove")
	public R remove( Integer tid){
		if(xyService.remove(tid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:xy:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] tids){
		xyService.batchRemove(tids);
		return R.ok();
	}
	
}
