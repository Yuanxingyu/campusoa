package org.stary.campusoa.common.controller;

import org.springframework.stereotype.Controller;
import org.stary.campusoa.common.utils.ShiroUtils;
import org.stary.campusoa.system.domain.UserDO;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}