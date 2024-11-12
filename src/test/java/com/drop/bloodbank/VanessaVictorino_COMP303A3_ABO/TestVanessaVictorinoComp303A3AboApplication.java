package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO;

import org.springframework.boot.SpringApplication;

public class TestVanessaVictorinoComp303A3AboApplication {

	public static void main(String[] args) {
		SpringApplication.from(VanessaVictorinoComp303A3AboApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
