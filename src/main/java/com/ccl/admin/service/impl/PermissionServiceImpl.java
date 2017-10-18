package com.ccl.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ccl.admin.entity.Permission;
import com.ccl.admin.mapper.PermissionMapper;
import com.ccl.admin.service.IPermissionService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lucare
 * @since 2017-03-06
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Page<Permission> selectPermPage(Page<Permission> page) {
        page.setRecords(permissionMapper.selectPermList(page));
        return page;
    }
}
