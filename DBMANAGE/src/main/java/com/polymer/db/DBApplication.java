package com.polymer.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(value = {"com.polymer.db.mapper"})
@EnableScheduling
@EnableCaching
public class DBApplication {
	public static void main(String[] args) {
		SpringApplication.run(DBApplication.class,args);
	}


}