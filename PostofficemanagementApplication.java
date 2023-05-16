package com.chainsys.postofficemanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PostofficemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostofficemanagementApplication.class, args);
		Logger logger = LoggerFactory.getLogger(PostofficemanagementApplication.class);
		logger.info("Post Office management");
	}
}

