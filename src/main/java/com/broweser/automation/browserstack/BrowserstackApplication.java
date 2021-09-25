package com.broweser.automation.browserstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class BrowserstackApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		SpringApplication.run(BrowserstackApplication.class, args);
	}
}
