package com.ccl.admin.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ccl.admin.entity.Role;
import com.ccl.admin.entity.UserRole;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Lucare
 * @since 2017-03-08
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<Role> findRoleListByUserId(long uid);

}