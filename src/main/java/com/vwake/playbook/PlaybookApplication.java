package com.vwake.playbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = "com.vwake")
public class PlaybookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaybookApplication.class, args);
	}

}
