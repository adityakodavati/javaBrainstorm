package com.grid.RestTemplateOps;

import com.grid.RestTemplateOps.entity.NameEntity;
import com.grid.RestTemplateOps.service.CrudOpsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class RestTemplateOpsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RestTemplateOpsApplication.class, args);
		CrudOpsService crudOpsService = context.getBean(CrudOpsService.class);
		System.out.println(crudOpsService.getAllNames());
		NameEntity nameEntity = new NameEntity();
		nameEntity.setName("aditya from rest template");
		System.out.println(crudOpsService.createNmae(nameEntity));
		crudOpsService.deleteName(2L);

		System.out.println(crudOpsService.getAllNames());

	}

}
