package com.netflix.eurekaservice;
/**
 * @author RammohanCHV
 * @purpose This class is the EurekaServer which will register product-list and customer-service.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer.class,args);
	}

}
