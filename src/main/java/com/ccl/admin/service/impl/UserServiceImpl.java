package com.ccl.admin.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ccl.admin.entity.Role;
import com.ccl.admin.entity.User;
import com.ccl.admin.mapper.*;
import com.ccl.admin.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<Role> findRolePermissions(long uid) {
        List<Role> roleIdList = userRoleMapper.findRoleListByUserId(uid);
        for (Role role : roleIdList) {
            Set<String> everyRolePer = rolePermissionMapper.findPermissions(role.getId());
            role.setPerNameSet(everyRolePer);
        }
        return roleIdList;
    }

    @Override
    public Page<User> selectUserPage(Page<User> page) {
        page.setRecords(userMapper.selectUserList(page));
        return page;
    }
}
