package com.pt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.pt.user.dao.nosqlRepo.UserRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.*")
@EnableSwagger2
@EnableCaching
//@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class Pcare {

	public static void main(String[] args) {
		SpringApplication.run(Pcare.class, args);
	}

}
