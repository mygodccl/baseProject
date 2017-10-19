package com.ccl.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ccl.admin.entity.UserRole;
import com.ccl.admin.mapper.UserRoleMapper;
import com.ccl.admin.service.IUserRoleService;

import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
	
}
