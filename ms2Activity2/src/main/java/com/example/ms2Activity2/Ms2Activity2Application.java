package com.example.ms2Activity2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableHystrixDashboard
@EnableFeignClients("com.example")
public class Ms2Activity2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ms2Activity2Application.class, args);
	}

}
