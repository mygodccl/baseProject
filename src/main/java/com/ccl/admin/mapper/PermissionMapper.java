package com.ccl.admin.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.ccl.admin.entity.Permission;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> selectPermList(Page<Permission> page);

}