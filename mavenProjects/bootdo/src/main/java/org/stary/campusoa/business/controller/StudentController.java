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

import org.stary.campusoa.business.domain.StudentDO;
import org.stary.campusoa.business.service.StudentService;
import org.stary.campusoa.common.utils.MD5Utils;
import org.stary.campusoa.common.utils.PageUtils;
import org.stary.campusoa.common.utils.Query;
import org.stary.campusoa.common.utils.R;
import org.stary.campusoa.system.domain.UserDO;
import org.stary.campusoa.system.service.UserService;

/**
 * 学生表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
 
@Controller
@RequestMapping("/business/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@Autowired
	private UserService userService;
	
	@GetMapping()
	@RequiresPermissions("business:student:student")
	String Student(){
	    return "business/student/student";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("business:student:student")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<StudentDO> studentList = studentService.list(query);
		int total = studentService.count(query);
		PageUtils pageUtils = new PageUtils(studentList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("business:student:add")
	String add(){
	    return "business/student/add";
	}

	@GetMapping("/edit/{tid}")
	@RequiresPermissions("business:student:edit")
	String edit(@PathVariable("tid") Integer tid,Model model){
		StudentDO student = studentService.get(tid);
		model.addAttribute("student", student);
	    return "business/student/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:student:add")
	public R save( StudentDO student){
		List<Long> roles = new ArrayList<>();
		roles.add(60l);
		UserDO user = new UserDO();
		user.setEmail(student.getEmail());
		user.setName(student.getXsname());
		user.setUsername(student.getXgh());
		user.setPassword(MD5Utils.encrypt(student.getXgh(), "123456"));
		user.setStatus(1);
		user.setRoleIds(roles);
		user.setDeptId(7l);
		user.setDeptName("学生一部");
		int userFlag = userService.save(user);
		UserDO userDO = null;
		if (userFlag>0){
			userDO = userService.getByUserName(student.getXgh());
		}
		student.setUserid(userDO.getUserId());
		int stuFlag = studentService.save(student);
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
	@RequiresPermissions("business:student:edit")
	public R update( StudentDO student){
		studentService.update(student);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:student:remove")
	public R remove( Integer tid){
		if(studentService.remove(tid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:student:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] tids){
		studentService.batchRemove(tids);
		return R.ok();
	}
	
}
