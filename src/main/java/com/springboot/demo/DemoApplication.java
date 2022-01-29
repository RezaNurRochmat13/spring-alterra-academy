package com.springboot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DemoApplication {

	private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		logger.info("Application is running");
		logger.debug("Application debugging is started");
	}

}
