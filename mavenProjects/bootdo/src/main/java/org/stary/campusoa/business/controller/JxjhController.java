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

import org.stary.campusoa.business.domain.JxjhDO;
import org.stary.campusoa.business.service.JxjhService;
import org.stary.campusoa.common.utils.PageUtils;
import org.stary.campusoa.common.utils.Query;
import org.stary.campusoa.common.utils.R;

/**
 * 教学计划表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
 
@Controller
@RequestMapping("/business/jxjh")
public class JxjhController {
	@Autowired
	private JxjhService jxjhService;
	
	@GetMapping()
	@RequiresPermissions("business:jxjh:jxjh")
	String Jxjh(){
	    return "business/jxjh/jxjh";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("business:jxjh:jxjh")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<JxjhDO> jxjhList = jxjhService.list(query);
		int total = jxjhService.count(query);
		PageUtils pageUtils = new PageUtils(jxjhList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("business:jxjh:add")
	String add(){
	    return "business/jxjh/add";
	}

	@GetMapping("/edit/{tid}")
	@RequiresPermissions("business:jxjh:edit")
	String edit(@PathVariable("tid") Integer tid,Model model){
		JxjhDO jxjh = jxjhService.get(tid);
		model.addAttribute("jxjh", jxjh);
	    return "business/jxjh/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:jxjh:add")
	public R save( JxjhDO jxjh){
		if(jxjhService.save(jxjh)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("business:jxjh:edit")
	public R update( JxjhDO jxjh){
		jxjhService.update(jxjh);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:jxjh:remove")
	public R remove( Integer tid){
		if(jxjhService.remove(tid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:jxjh:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] tids){
		jxjhService.batchRemove(tids);
		return R.ok();
	}

	/**
	 * 查找
	 */
	@GetMapping( "/queryByproperties")
	@ResponseBody
	@RequiresPermissions("business:jxjh:jxjh")
	public List<JxjhDO> queryByproperties(@RequestParam Map<String, Object> params){
		return jxjhService.list(params);
	}
	
}
