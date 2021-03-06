package com.converse.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;


@EnableAutoConfiguration(
		exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class ConverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConverseApplication.class, args);
	}

}
