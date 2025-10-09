package com.grid.discovery_cllient_2;

import com.grid.discovery_cllient_2.service.FeignClientTestClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DiscoveryCllient2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =SpringApplication.run(DiscoveryCllient2Application.class, args);
		FeignClientTestClass testClass = context.getBean(FeignClientTestClass.class);
		testClass.deleteById(3L);
		testClass.printAllNames();

	}

}
