package com.ccl.admin.web;
//package com.ccl.admin.web;
//
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.baomidou.mybatisplus.plugins.Page;
//import com.ccl.admin.entity.Permission;
//import com.ccl.admin.service.IPermissionService;
//
///**
// * <p>
// *  前端控制器
// * </p>
// *
// * @author Lucare
// * @since 2017-03-06
// */
//@Controller
//@RequestMapping("/admin/perm")
//public class PermissionController {
//
//    @Autowired
//    private IPermissionService permissionService;
//
//    @RequiresPermissions("admin:perm:view")
//    @RequestMapping("/index")
//    public String index() {
//        return "admin/perm/list";
//    }
//
//    @RequiresPermissions("admin:perm:view")
//    @RequestMapping("/list")
//    @ResponseBody
//    public Page<Permission> list() {
//        Page<Permission> page = permissionService.selectPermPage(new Page<Permission>(0, 12));
//        return page;
//    }
//	
//}
