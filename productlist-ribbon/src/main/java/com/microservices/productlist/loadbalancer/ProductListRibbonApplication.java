package com.microservices.productlist.loadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductListRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductListRibbonApplication.class, args);
	}

}
