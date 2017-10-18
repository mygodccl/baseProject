package com.ccl.common.config.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ccl.common.config.security.md5.SaltPropertie;

public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@SaltPropertie
	private String username;//用户名
	
	private String password;//密码
	
	private Collection<SimpleGrantedAuthority> authorities;//权限
	
	private Boolean accountNonExpired = true;//账户是否过期
	private Boolean accountNonLocked = true;//账户是否锁定
	private Boolean credentialsNonExpired = true;//证书是否过期
	private Boolean enabled = true;//是否启用

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public CustomUserDetails(String username, String password, Collection<SimpleGrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setAuthorities(Collection<SimpleGrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
