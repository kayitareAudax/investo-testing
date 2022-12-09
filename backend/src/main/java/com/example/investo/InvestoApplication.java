package com.example.investo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.investo.model"})
@ComponentScan(basePackages = {"com.example.investo.repository", "com.example.investo.service", "com.example.investo.controller"})
@EnableJpaRepositories(basePackages = {"com.example.investo.repository"})
public class InvestoApplication {
    public static void main(String[] args) {
        SpringApplication.run(InvestoApplication.class, args);
    }
//	@Bean
//	CommandLineRunner run(CompanyService companyService){
//		return args ->{
//			companyService.saveCompany(new Company("Bookinga",3000,50,15000));
//			companyService.saveCompany(new Company("TURA",2000,40,200000));
//			companyService.saveCompany(new Company("MINE",1000,30,400000));
//		};
//	}
}
