package com.prf.inventario.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class InMemorySecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
			.withUser("thamires").password("{noop}123").roles("PG_AMBIENTES", "PG_BASES", "PG_INSTANCIAS", "PG_SERVIDORES", "PG_SGBDS", "PG_SISTEMAS", "PG_SISTEMASOPERACIONAIS", "PG_USUARIOS")
			.and()
			.withUser("vitor").password("{noop}123").roles("PG_AMBIENTES");
	}

}
