package com.ccl.admin.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.ccl.admin.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User findByName(String name);

    List<User> selectUserList(Page<User> page);

}