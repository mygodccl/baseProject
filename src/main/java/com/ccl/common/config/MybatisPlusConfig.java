package com.ccl.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;

/**
 * Created by Lucare.Feng on 2017/2/24.
 * update on 2017/07/13
 */
@Configuration
@MapperScan("com.ccl.*.mapper*")
public class MybatisPlusConfig {
	
	/**
	 * SQL分析插件
	 * @return
	 */
	@Bean
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		return performanceInterceptor;
	}
    
	/**
     *	 mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    
}
