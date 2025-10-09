package com.grid.discovery_cllient_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class DiscoveryCllient1Application {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryCllient1Application.class, args);

	}

}
