//package com.ccl.admin.web;
//
//import org.apache.shiro.SecurityUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class IndexController {
//   
//	@RequestMapping("/")
//    public String index(Model model) {
//        System.out.println("this is frame");
//        return "common/frame";
//    }
//
//
//    @RequestMapping("/index")
//    public String list(Model model) {
//        System.out.println("this is index");
//        return "index";
//    }
//    @RequestMapping("/logout")
//    public String logout() {
//    	SecurityUtils.getSubject().logout();
//    	return "login";
//    }
//
//}
