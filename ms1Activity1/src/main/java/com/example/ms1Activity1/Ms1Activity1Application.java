package com.example.ms1Activity1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableEurekaClient
@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class Ms1Activity1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ms1Activity1Application.class, args);
	}

}
