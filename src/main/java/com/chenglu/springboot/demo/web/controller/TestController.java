package com.chenglu.springboot.demo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping(value = "/regist")
	public String regist(HttpServletRequest request) {
		return "regist";
	}
	
}
