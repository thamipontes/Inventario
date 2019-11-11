package com.prf.inventario.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests()
				.antMatchers("ambientes/index").hasAnyRole("PG_AMBIENTES")
				.antMatchers("/bases").hasAnyRole("PG_BASES")
				.antMatchers("/instancias").hasAnyRole("PG_INSTANCIAS")
				.antMatchers("/servidores").hasAnyRole("PG_SERVIDORES")
				.antMatchers("/sgbds").hasAnyRole("PG_SGBDS")
				.antMatchers("/sistemas").hasAnyRole("PG_SISTEMAS")
				.antMatchers("/sistemasOperacionais").hasAnyRole("PG_SISTEMASOPERACIONAIS")
				.antMatchers("/usuarios").hasAnyRole("PG_USUARIOS")
				.anyRequest()
				.authenticated() //para qualquer requisição o usuário deve ser autenticado
				.and()
				.formLogin()
					.loginPage("/entrar")
					.permitAll();
	}

}
