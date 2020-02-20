package com.prf.Chamado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

//@ComponentScan(basePackages={"com.prf"})
@SpringBootApplication
@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class ChamadoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ChamadoApplication.class, args);
		//System.out.println(new BCryptPasswordEncoder().encode("benspassword"));
	}

}

