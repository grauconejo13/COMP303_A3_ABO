package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

@SpringBootApplication
@ComponentScan(basePackages = {
	    "com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO",
	    "com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers",
	    "com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities",
	    "com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services"
	    })
public class VanessaVictorinoComp303A3AboApplication {

	public static void main(String[] args) {
		SpringApplication.run(VanessaVictorinoComp303A3AboApplication.class, args);
	}
	
	 @Bean
	    public SpringResourceTemplateResolver templateResolver() {
	        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	        templateResolver.setPrefix("classpath:/templates/");
	        templateResolver.setSuffix(".html");
	        templateResolver.setTemplateMode(TemplateMode.HTML);
	        templateResolver.setCharacterEncoding("UTF-8");
	        return templateResolver;
	    }

}
