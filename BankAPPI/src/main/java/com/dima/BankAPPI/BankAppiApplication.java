package com.dima.BankAPPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.dima.BankAPPI.entity")
public class BankAppiApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankAppiApplication.class, args);
	}
}
