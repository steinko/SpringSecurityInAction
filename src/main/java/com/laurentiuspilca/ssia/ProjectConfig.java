package com.laurentiuspilca.ssia;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class ProjectConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		var userDetailsService = new InMemoryUserDetailsManager();
		var user = User.withUsername("Stein")
				       .password("12345")
				       .authorities("read")
				       .build();
		userDetailsService.createUser(user);
		return userDetailsService;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
