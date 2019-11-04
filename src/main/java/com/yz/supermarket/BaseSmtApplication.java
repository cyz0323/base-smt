package com.yz.supermarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yz.supermarket.mapper")
public class BaseSmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseSmtApplication.class, args);
	}

}
