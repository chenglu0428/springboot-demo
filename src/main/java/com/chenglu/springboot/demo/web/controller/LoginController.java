package com.chenglu.springboot.demo.web.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenglu.springboot.demo.web.common.SecurityUtils;
import com.chenglu.springboot.demo.web.entity.TblUser;
import com.chenglu.springboot.demo.web.service.TblUserService;

@Controller
public class LoginController {
	@Autowired
	private TblUserService userService;
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/testLogin";
	}
	
	@RequestMapping(value = "/testLogin")
	public String testLogin(HttpServletRequest request) {
		return "testLogin";
	}
	
	@RequestMapping(value = "/getToken")
	public String getToken(HttpServletRequest request, Model model) {
		try {
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("email");
			String id = UUID.randomUUID().toString().replace("-", "");
			TblUser user = new TblUser();
			user.setId(id);
			user.setMobile(mobile);
			user.setEmail(email);
			userService.save(user);
			SecurityUtils.setUser(user);
			model.addAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
