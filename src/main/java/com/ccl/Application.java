package com.ccl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableScheduling
//@EnableAsync
public class Application {

	/**
	 * <p>
	 * 测试 RUN
	 * <br>
	 * 1、http://localhost:8080
	 * 2、http://localhost:8080/user/test1<br>
	 * </p>
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
