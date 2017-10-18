package com.ccl.admin.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ccl.admin.entity.Role;
import com.ccl.admin.mapper.RoleMapper;
import com.ccl.admin.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lucare
 * @since 2017-03-06
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Page<Role> selectRolePage(Page<Role> page) {
        page.setRecords(roleMapper.selectRoleList(page));
        return page;
    }
}
