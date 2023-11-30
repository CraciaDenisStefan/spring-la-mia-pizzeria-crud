package org.java.spring;

import org.java.spring.db.pojo.Pizzeria;
import org.java.spring.db.serve.Pizzeriaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{

	@Autowired
	private Pizzeriaservice pizzeriaService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		pizzeriaService.save(new Pizzeria("da denis","e buona","",2.50));
		pizzeriaService.save(new Pizzeria("da stean","no buono","url",7.50));
	
	}

}
