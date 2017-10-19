//package com.ccl.admin.web;
//
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.baomidou.mybatisplus.plugins.Page;
//import com.ccl.admin.entity.Role;
//import com.ccl.admin.service.IRoleService;
//
//@Controller
//@RequestMapping("/admin/role")
//public class RoleController {
//
//    @Autowired
//    private IRoleService roleService;
//
//    @RequiresPermissions("admin:role:view")
//    @RequestMapping("/index")
//    public String index() {
//        return "admin/role/list";
//    }
//
//    @RequiresPermissions("admin:role:view")
//    @RequestMapping("/list")
//    @ResponseBody
//    public Page<Role> list() {
//        Page<Role> page = roleService.selectRolePage(new Page<Role>(0, 12));
//        return page;
//    }
//	
//}
