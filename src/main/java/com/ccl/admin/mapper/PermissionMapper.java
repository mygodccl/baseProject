package com.ccl.admin.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.ccl.admin.entity.Permission;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Lucare
 * @since 2017-03-06
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> selectPermList(Page<Permission> page);

}