package com.ccl.admin.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.ccl.admin.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

    List<Long> findRoleIdListByUserId(long uid);

    List<Role> selectRoleList(Page<Role> page);

}