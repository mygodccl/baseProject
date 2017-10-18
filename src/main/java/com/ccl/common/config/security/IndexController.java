package com.fcs.common.config.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {
		return "home";
	}

	@RequestMapping("/admin")
	@ResponseBody
	public String hello() {
		return "hello admin";
	}
}