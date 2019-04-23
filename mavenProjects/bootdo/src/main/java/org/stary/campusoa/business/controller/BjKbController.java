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

import org.stary.campusoa.business.domain.BjKbDO;
import org.stary.campusoa.business.service.BjKbService;
import org.stary.campusoa.common.utils.PageUtils;
import org.stary.campusoa.common.utils.Query;
import org.stary.campusoa.common.utils.R;

/**
 * 班级统一课表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
 
@Controller
@RequestMapping("/business/bjKb")
public class BjKbController {
	@Autowired
	private BjKbService bjKbService;
	
	@GetMapping()
	@RequiresPermissions("business:bjKb:bjKb")
	String BjKb(){
	    return "business/bjKb/bjKb";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("business:bjKb:bjKb")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BjKbDO> bjKbList = bjKbService.list(query);
		int total = bjKbService.count(query);
		PageUtils pageUtils = new PageUtils(bjKbList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("business:bjKb:add")
	String add(){
	    return "business/bjKb/add";
	}

	@GetMapping("/edit/{tid}")
	@RequiresPermissions("business:bjKb:edit")
	String edit(@PathVariable("tid") Integer tid,Model model){
		BjKbDO bjKb = bjKbService.get(tid);
		model.addAttribute("bjKb", bjKb);
	    return "business/bjKb/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:bjKb:add")
	public R save( BjKbDO bjKb){
		if(bjKbService.save(bjKb)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("business:bjKb:edit")
	public R update( BjKbDO bjKb){
		bjKbService.update(bjKb);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:bjKb:remove")
	public R remove( Integer tid){
		if(bjKbService.remove(tid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:bjKb:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] tids){
		bjKbService.batchRemove(tids);
		return R.ok();
	}
	
}
