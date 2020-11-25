package com.sist.org;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sist.org.mapper")
public class SistemaappBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaappBackendApplication.class, args);
	}
}
