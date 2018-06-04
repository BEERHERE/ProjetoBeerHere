package com.eventoapp.eventoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.eventoapp.eventoapp.controllers"})
@SpringBootApplication
public class EventoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventoappApplication.class, args);
	}
}
