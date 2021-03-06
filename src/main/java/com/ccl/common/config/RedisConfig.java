package com.ccl.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.ccl.common.redis.RedisObjectSerializer;


@Configuration
public class RedisConfig {
	
	@Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

	@Bean
	public <T> RedisTemplate<String, T> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, T> template = new RedisTemplate<String, T>();
		template.setConnectionFactory(factory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new RedisObjectSerializer());
		return template;
	}

}
