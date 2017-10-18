package com.ccl.common.config;
//package com.ccl.common.config;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.servlet.SimpleCookie;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.crazycake.shiro.RedisCacheManager;
//import org.crazycake.shiro.RedisManager;
//import org.crazycake.shiro.RedisSessionDAO;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.core.env.Environment;
//
//import com.ccl.common.MySessionListener1;
//import com.ccl.common.ShiroRealm;
//import com.google.common.collect.Lists;
//
///**
// * Created by Lucare.Feng on 2017/3/6.
// */
//@Configuration
//public class ShiroConfiguration implements EnvironmentAware {
//	
//    private Environment env;
//	
//    @Bean(name = "lifecycleBeanPostProcessor")
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
////    @Bean(name = "hashedCredentialsMatcher")
////    public HashedCredentialsMatcher hashedCredentialsMatcher() {
////        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
////        credentialsMatcher.setHashAlgorithmName("MD5");
////        credentialsMatcher.setHashIterations(2);
////        credentialsMatcher.setStoredCredentialsHexEncoded(true);
////        return credentialsMatcher;
////    }
//
//    @Bean(name = "shiroRealm")
//    @DependsOn("lifecycleBeanPostProcessor")
//    public ShiroRealm shiroRealm() {
//        ShiroRealm realm = new ShiroRealm();
////        realm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return realm;
//    }
//
////    @Bean(name = "ehCacheManager")
////    @DependsOn("lifecycleBeanPostProcessor")
////    public EhCacheManager ehCacheManager(){
////        EhCacheManager ehCacheManager = new EhCacheManager();
////        return ehCacheManager;
////    }
//    
//    @Bean(name = "redisManager")
//    public RedisManager redisManager() {
//    	RedisManager redisManager = new RedisManager();
//    	redisManager.setHost(env.getProperty("spring.redis.host"));
//    	redisManager.setPort(env.getProperty("spring.redis.port", Integer.class));
//    	redisManager.setPassword(env.getProperty("spring.redis.password"));
//    	redisManager.setExpire(env.getProperty("spring.shiro.timeout",  Integer.class));
//    	return redisManager;
//    }
//    
//    @Bean(name = "cacheManager")
//    public RedisCacheManager cacheManager() {
//    	RedisCacheManager redisCacheManager = new RedisCacheManager();
//    	redisCacheManager.setRedisManager(redisManager());
//    	return redisCacheManager;
//    }
//    
//    @Bean(name = "sessionListeners")
//    public MySessionListener1 mySessionListener1() {
//    	MySessionListener1 mySessionListener1 = new MySessionListener1();
//    	return mySessionListener1;
//    }
//   
//    @Bean(name = "sessionIdCookie")
//    public SimpleCookie sessionIdCookie() {
//    	SimpleCookie sessionIdCookie = new SimpleCookie();
//        sessionIdCookie.setHttpOnly(true);
//        sessionIdCookie.setName("sid");
//    	return sessionIdCookie;
//    }
//    
//    @Bean(name = "sessionDAO")
//    public RedisSessionDAO sessionDAO() {
//    	RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
//    	redisSessionDAO.setKeyPrefix("shiro:auth");
//    	redisSessionDAO.setRedisManager(redisManager());
//    	return redisSessionDAO;
//    }
//    
//    @Bean(name = "sessionManager")
//    public DefaultWebSessionManager sessionManager() {
//    	DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//    	
//    	sessionManager.setSessionListeners(Lists.newArrayList(mySessionListener1()));
//    	
//    	sessionManager.setSessionIdCookie(sessionIdCookie());
//    	
//    	sessionManager.setSessionDAO(sessionDAO());
//    	
//    	return sessionManager;
//    }
//    
//    @Bean(name = "securityManager")
//    public DefaultWebSecurityManager securityManager(){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();//配置一个web安全管理器
//        securityManager.setRealm(shiroRealm());//设置改管理器的资源获取类
//        
//        securityManager.setCacheManager(cacheManager());
//        
//        securityManager.setSessionManager(sessionManager());
//        
//        return securityManager;
//    }
//
//    @Bean(name = "shiroFilter")
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager  securityManager){
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
////        Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
////        LogoutFilter logoutFilter = new LogoutFilter();
////        logoutFilter.setRedirectUrl("/login");
////        filters.put("logout", logoutFilter);
////        shiroFilterFactoryBean.setFilters(filters);
//
//        Map<String, String> filterChainDefinitionManager = new LinkedHashMap<>();
//        filterChainDefinitionManager.put("/logout", "logout");
//        filterChainDefinitionManager.put("/user/**", "authc,roles[user]");
//        filterChainDefinitionManager.put("/shop/**", "authc,roles[shop]");
//        filterChainDefinitionManager.put("/admin/**", "authc,roles[admin]");
//        filterChainDefinitionManager.put("/**", "anon");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
//
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        shiroFilterFactoryBean.setSuccessUrl("/");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//
//        return shiroFilterFactoryBean;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
//        daap.setProxyTargetClass(true);
//        return daap;
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
//        aasa.setSecurityManager(securityManager);
//        return aasa;
//    }
//
//	@Override
//	public void setEnvironment(Environment environment) {
//		this.env = environment;
//	}
//
////    @Bean(name = "shiroDialect")
////    public ShiroDialect shiroDialect(){
////        return new ShiroDialect();
////    }
//
//}
