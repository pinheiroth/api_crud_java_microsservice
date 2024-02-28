package com.th.ti_burguer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TiBurguerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiBurguerApplication.class, args);
	}

}
