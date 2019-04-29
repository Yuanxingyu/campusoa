package org.stary.campusoa.business.controller;

import java.util.ArrayList;
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

import org.stary.campusoa.business.domain.TeacherDO;
import org.stary.campusoa.business.service.TeacherService;
import org.stary.campusoa.common.utils.MD5Utils;
import org.stary.campusoa.common.utils.PageUtils;
import org.stary.campusoa.common.utils.Query;
import org.stary.campusoa.common.utils.R;
import org.stary.campusoa.system.domain.UserDO;
import org.stary.campusoa.system.service.UserService;

/**
 * 教师表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
 
@Controller
@RequestMapping("/business/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@Autowired
	private UserService userService;
	
	@GetMapping()
	@RequiresPermissions("business:teacher:teacher")
	String Teacher(){
	    return "business/teacher/teacher";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("business:teacher:teacher")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TeacherDO> teacherList = teacherService.list(query);
		int total = teacherService.count(query);
		PageUtils pageUtils = new PageUtils(teacherList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("business:teacher:add")
	String add(){
	    return "business/teacher/add";
	}

	@GetMapping("/edit/{tid}")
	@RequiresPermissions("business:teacher:edit")
	String edit(@PathVariable("tid") Integer tid,Model model){
		TeacherDO teacher = teacherService.get(tid);
		model.addAttribute("teacher", teacher);
	    return "business/teacher/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:teacher:add")
	public R save( TeacherDO teacher){

		List<Long> roles = new ArrayList<>();
		roles.add(59l);
		UserDO user = new UserDO();
		user.setEmail(teacher.getEmail());
		user.setName(teacher.getJsname());
		user.setUsername(teacher.getJgh());
		user.setPassword(MD5Utils.encrypt(teacher.getJgh(), "123456"));
		user.setStatus(1);
		user.setRoleIds(roles);
		user.setDeptId(12l);
		user.setDeptName("教学一部");
		int userFlag = userService.save(user);
		UserDO userDO = null;
		if (userFlag>0){
			userDO = userService.getByUserName(teacher.getJgh());
		}
		teacher.setUserid(userDO.getUserId());
		int stuFlag = teacherService.save(teacher);
		if (userFlag> 0&& stuFlag>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("business:teacher:edit")
	public R update( TeacherDO teacher){
		teacherService.update(teacher);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:teacher:remove")
	public R remove( Integer tid){
		if(teacherService.remove(tid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:teacher:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] tids){
		teacherService.batchRemove(tids);
		return R.ok();
	}
	
}
