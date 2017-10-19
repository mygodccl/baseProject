package com.ccl.admin.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ccl.admin.entity.Role;
import com.ccl.admin.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {
	
    User findByName(String name);

    List<Role> findRolePermissions(long uid);

    Page<User> selectUserPage(Page<User> page);

}
