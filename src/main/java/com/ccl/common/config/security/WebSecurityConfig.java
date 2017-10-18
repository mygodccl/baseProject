package com.ccl.common.config.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.ccl.common.config.security.extra.RedisUserCache;
import com.ccl.common.config.security.md5.AnnotationSaltSource;
import com.ccl.common.config.security.md5.Md5PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public AccessDecisionManager accessDecisionManager() {
		return new CustomAccessDecisionManager();
	}

	@Bean
	public FilterInvocationSecurityMetadataSource securityMetadataSource() {
		return new CustomInvocationSecurityMetadataSource();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
				.and().formLogin().loginPage("/login").defaultSuccessUrl("/", true).failureUrl("/login?error")
				.permitAll().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
					@Override
					public <O extends FilterSecurityInterceptor> O postProcess(O filter) {
						filter.setAccessDecisionManager(accessDecisionManager());
						filter.setSecurityMetadataSource(securityMetadataSource());
						return filter;
					}
				}).and().logout().addLogoutHandler(new LogoutHandler() {
					@Override
					public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
						CustomUserDetails user = (CustomUserDetails)authentication.getPrincipal();
						userCache().removeUserFromCache(user.getUsername());
					}
				});
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public MessageDigestPasswordEncoder passwordEncoder() {
		return new Md5PasswordEncoder();
	}
	
	@Bean
	public SaltSource saltSource() {
		return new AnnotationSaltSource();
	}
	
	@Bean
	public RedisUserCache userCache() {
		return new RedisUserCache();
	}
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).withObjectPostProcessor(new ObjectPostProcessor<DaoAuthenticationProvider>() {
			@Override
			public <O extends DaoAuthenticationProvider> O postProcess(O provider) {
				provider.setPasswordEncoder(passwordEncoder());
				provider.setSaltSource(saltSource());
				provider.setUserCache(userCache());
				return provider;
			}
		});
		super.configure(auth);
	}

}