package com.ccl.admin.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ccl.admin.entity.Role;

public interface IRoleService extends IService<Role> {

    Page<Role> selectRolePage(Page<Role> page);
	
}
