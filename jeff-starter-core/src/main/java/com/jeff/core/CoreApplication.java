package com.jeff.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//如果不增加 scanBasePackages，在其它模塊的配置類會導致掃描不到
@SpringBootApplication(scanBasePackages = "com.jeff.core")
@MapperScan(basePackages = "com.jeff.**.dao")
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
