package com.ccl.common.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ccl.admin.entity.Role;
import com.ccl.admin.entity.User;
import com.ccl.admin.mapper.UserMapper;
import com.ccl.admin.mapper.UserRoleMapper;

@Service
public class CustomUserDetailsService implements UserDetailsService {
   
	@Autowired  //数据库服务类
    private UserMapper userMapper;
	@Autowired  //数据库服务类
	private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SUser中的email作为用户名:
        User user = userMapper.findByName(userName); 

        if (user == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }

        CustomUserDetails securityUser = new CustomUserDetails(user.getUsername(), user.getPassword(), getRoleNamesByUsername(user.getId()));
        return securityUser; 

    }
    
    //获取用户的权限, 即角色(UserDetails里面会需要这个)
    private Collection<SimpleGrantedAuthority> getRoleNamesByUsername(Long userid){
    	Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    	List<Role> roleList = userRoleMapper.findRoleListByUserId(userid);
    	for (Role role : roleList) {
    		authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
    	return authorities;
    }

}