package com.yc.fresh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.entity.AdminInfo;
import com.yc.fresh.service.IAdminInfoService;

@Controller
@RequestMapping("/admin")
public class AdminInfoController {
	@Autowired
	private IAdminInfoService adminInfoService;

	@RequestMapping("/login")
	@ResponseBody
	public int login(HttpSession session, AdminInfo af) {
		AdminInfo adminInfo = adminInfoService.login(af);
		if (adminInfo != null) {
			session.setAttribute("currentLoginAdmin", adminInfo);
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/manager")
	public String manager(HttpSession session) {
		return "index";
	}
}
