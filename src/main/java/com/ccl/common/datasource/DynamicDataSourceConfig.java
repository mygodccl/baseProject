package com.ccl.common.datasource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DynamicDataSourceConfig {
	
	public HikariDataSource dataSourceOne() {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/skeleton_shiro?characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
		hikariDataSource.setUsername("root");
		hikariDataSource.setPassword("root");
		return hikariDataSource;
	}
	
	public HikariDataSource dataSourceTwo() {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/skeleton_shiro?characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
		hikariDataSource.setUsername("root");
		hikariDataSource.setPassword("root");
		return hikariDataSource;
	}
	
	@Bean
	public DynamicDataSource dynamicDataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		
		//放置两个数据源
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DBTypeEnum.one.getValue(), dataSourceOne());
		targetDataSources.put(DBTypeEnum.two.getValue(), dataSourceTwo());
		dynamicDataSource.setTargetDataSources(targetDataSources);
		
		//默认选择第一个数据源(作为启动所需数据源)
		DbContextHolder.setDbType(DBTypeEnum.one);
		
		return dynamicDataSource;
	}
}
