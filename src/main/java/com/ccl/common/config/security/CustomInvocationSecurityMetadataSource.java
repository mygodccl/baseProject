package com.ccl.common.config.security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ccl.admin.entity.Permission;
import com.ccl.admin.mapper.PermissionMapper;
import com.ccl.admin.mapper.RolePermissionMapper;

/**
 * 这个类用于加载用户和用户的权限到spring security的的缓存中...这里选择从数据库加载
 * @author chenchuanliang
 *
 */
@Service
public class CustomInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    private org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    /**
     * 加载资源，初始化资源变量
     */
    @PostConstruct
    public void loadResourceDefine() {
        if (resourceMap == null) {
            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
            List<Permission> permissions= permissionMapper.selectList(new EntityWrapper<>());
            Collection<ConfigAttribute> roleNames;
            ConfigAttribute roleName;
            for (Permission permission : permissions) {
            	roleNames = new ArrayList<ConfigAttribute>();
                Set<String> roles = rolePermissionMapper.findRoles(permission.getId());
                for (String mame : roles) {
                	roleName = new SecurityConfig(mame);
                	roleNames.add(roleName);
				}
                resourceMap.put(permission.getUrl(), roleNames);
            }
        }
        log.info("权限资源关系加载成功!!");
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (resourceMap == null) loadResourceDefine();
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
       // 返回当前 url  所需要的权限
         return resourceMap.get(requestUrl);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
