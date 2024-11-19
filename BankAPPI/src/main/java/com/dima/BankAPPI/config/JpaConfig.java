package com.dima.BankAPPI.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.dima.BankAPPI.entity")
@EnableJpaRepositories("com.dima.BankAPPI.repository")
public class JpaConfig {

}
