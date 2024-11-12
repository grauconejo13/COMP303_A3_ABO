package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(VanessaVictorinoComp303A3AboApplication.class);
	}

}
