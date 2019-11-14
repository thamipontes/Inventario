package com.prf.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class InventarioApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha"));
	}


}
 