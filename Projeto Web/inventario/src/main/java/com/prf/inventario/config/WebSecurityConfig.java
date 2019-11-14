package com.prf.inventario.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.GET, "/ambientes").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder()); //gerar senha criptografada.
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/materialize/**", "/style/**");
	}
	
	
	

	/*
	@Autowired
	private LoginUsuarioService loginUsuarioService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginUsuarioService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest().hasAnyRole("PG_AMBIENTES","ADMIN")
		.and()
		.authorizeRequests().antMatchers("/**").permitAll()
		.and()		
	    .authorizeRequests().antMatchers("/entrar").permitAll()
	    .and().formLogin().loginPage("/entrar").permitAll()
	    .and()
	    .csrf().disable();
		
		.antMatchers("/ambientes").hasAnyRole("PG_AMBIENTES")
		.antMatchers("/bases").hasAnyRole("PG_BASES")
		.antMatchers("/instancias").hasAnyRole("PG_INSTANCIAS")
		.antMatchers("/servidores").hasAnyRole("PG_SERVIDORES")
		.antMatchers("/sgbds").hasAnyRole("PG_SGBDS")
				.antMatchers("/sistemas").hasAnyRole("PG_SISTEMAS").antMatchers("/sistemasOperacionais")
				.hasAnyRole("PG_SISTEMASOPERACIONAIS").antMatchers("/usuarios").hasAnyRole("PG_USUARIOS").anyRequest()
				.hasAnyRole("ADMIN", "LOGINUSUARIO").and().authorizeRequests().antMatchers("/entrar**").permitAll()
				.and().formLogin().loginPage("/entrar").permitAll();
				
	}
*/

}
