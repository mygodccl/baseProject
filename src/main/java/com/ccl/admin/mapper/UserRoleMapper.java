package com.ccl.admin.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ccl.admin.entity.Role;
import com.ccl.admin.entity.UserRole;

public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<Role> findRoleListByUserId(long uid);

}