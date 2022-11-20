package com.ienglish.tempForm;

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

	public static void main(String[] args) {
		SpringApplication.run(TempFormApplication.class, args);
	}

}
