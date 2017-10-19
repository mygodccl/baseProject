package com.ccl.admin.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ccl.admin.entity.Permission;

public interface IPermissionService extends IService<Permission> {

    Page<Permission> selectPermPage(Page<Permission> page);
	
}
