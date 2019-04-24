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

import org.stary.campusoa.business.domain.ZyDO;
import org.stary.campusoa.business.service.ZyService;
import org.stary.campusoa.common.utils.PageUtils;
import org.stary.campusoa.common.utils.Query;
import org.stary.campusoa.common.utils.R;

/**
 * 专业
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
 
@Controller
@RequestMapping("/business/zy")
public class ZyController {
	@Autowired
	private ZyService zyService;
	
	@GetMapping()
	@RequiresPermissions("business:zy:zy")
	String Zy(){
	    return "business/zy/zy";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("business:zy:zy")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ZyDO> zyList = zyService.list(query);
		int total = zyService.count(query);
		PageUtils pageUtils = new PageUtils(zyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("business:zy:add")
	String add(){
	    return "business/zy/add";
	}

	@GetMapping("/edit/{tid}")
	@RequiresPermissions("business:zy:edit")
	String edit(@PathVariable("tid") Integer tid,Model model){
		ZyDO zy = zyService.get(tid);
		model.addAttribute("zy", zy);
	    return "business/zy/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:zy:add")
	public R save( ZyDO zy){
		if(zyService.save(zy)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("business:zy:edit")
	public R update( ZyDO zy){
		zyService.update(zy);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:zy:remove")
	public R remove( Integer tid){
		if(zyService.remove(tid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:zy:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] tids){
		zyService.batchRemove(tids);
		return R.ok();
	}

	/**
	 * 查找
	 */
	@GetMapping( "/queryByproperties")
	@ResponseBody
	@RequiresPermissions("business:zy:zy")
	public List<ZyDO> queryByproperties(@RequestParam Map<String, Object> params){
		return zyService.list(params);
	}
	
}
