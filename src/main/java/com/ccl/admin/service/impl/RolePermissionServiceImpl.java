package com.ccl.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ccl.admin.entity.RolePermission;
import com.ccl.admin.mapper.RolePermissionMapper;
import com.ccl.admin.service.IRolePermissionService;

import org.springframework.stereotype.Service;

@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {
	
}
