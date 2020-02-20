package com.prf.Chamado;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		

		auth.ldapAuthentication()
				.userDnPatterns("uid={0},ou=people")
				.groupSearchBase("ou=groups")
				.contextSource()
				.ldif("classpath:src/main/resources/test-server.ldif")
				.root("dc=springframework,dc=org")
				.url("ldap://localhost:8389/dc=springframework,dc=org").and().passwordCompare()
				.passwordEncoder(new BCryptPasswordEncoder()).passwordAttribute("userPassword");
	}
	
	
	/*
	 * auth.ldapAuthentication() .userDnPatterns("uid={0},ou=people")
	 * .userSearchBase("ou=people") .userSearchFilter("uid={0}")
	 * .groupSearchBase("ou=groups") .groupSearchFilter("uniqueMember={0}")
	 * .contextSource() .url("ldap://localhost:8389/dc=concretepage,dc=com") .and()
	 * .passwordCompare() .passwordEncoder(passwordEncoder())
	 * .passwordAttribute("userPassword");
	 * 
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { BCryptPasswordEncoder
	 * passwordEncoder = new BCryptPasswordEncoder(); return passwordEncoder; }
	 * 
	 */

	/*
	 * 
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.ldapAuthentication() .userDnPatterns("uid={0},ou=people")
	 * .groupSearchBase("ou=groups") .contextSource(contextSource())
	 * .passwordCompare() .passwordEncoder(new
	 * LdapShaPasswordEncoder()).passwordAttribute("userPassword"); }
	 * 
	 * @Bean public DefaultSpringSecurityContextSource contextSource() { return new
	 * DefaultSpringSecurityContextSource(Arrays.asList("ldap://localhost:8389/"),
	 * "dc=springframework,dc=org"); } 
	 */

	
	//Permite que essas pastas não precisem da autenticação para funcionarem	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/bootstrap-4.3.1-dist/**", "/images/**", "/css/**");
	}
}
