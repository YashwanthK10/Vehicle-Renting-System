package com.example.vms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
			.csrf(csrf -> csrf.disable()) // csrf - cross-site request forgery - csrf means it is a token mechanism where it will protect from csrf attacks from hackers.            
			.authorizeHttpRequests(authorize -> authorize
														.requestMatchers("/customer-register", "/renting-partner-register", "/find-all-vehicle") // find-all-vehicles
														.permitAll()
														.anyRequest()
														.authenticated())
			.formLogin(Customizer.withDefaults()) // form login is used when u want to perform http session based authentication.
			.build();
	}

}
