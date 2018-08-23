package com.microservices.customer.loadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(CustomerApplication.class,args);
		CustomerConsumerController client=ctx.getBean(CustomerConsumerController.class);
		client.getProducts();
		client.getProduct(0);
	}
	
	@Bean
	public CustomerConsumerController getClient() {
		return new CustomerConsumerController();
	}
}
