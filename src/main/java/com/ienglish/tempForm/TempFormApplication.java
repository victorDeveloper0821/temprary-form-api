package com.ienglish.tempForm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.ienglish.*")
@EnableJpaRepositories
@EntityScan(basePackages = "com.ienglish.domain")
public class TempFormApplication {

	private static Logger logger = LogManager.getLogger(TempFormApplication.class);
	public static void main(String[] args) {
		logger.info("start web api server ! ");
		SpringApplication.run(TempFormApplication.class, args);
	}

}
