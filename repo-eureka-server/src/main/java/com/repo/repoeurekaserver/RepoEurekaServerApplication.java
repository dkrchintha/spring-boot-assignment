package com.dkr.repoeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RepoEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonEurekaServerApplication.class, args);
	}
}
