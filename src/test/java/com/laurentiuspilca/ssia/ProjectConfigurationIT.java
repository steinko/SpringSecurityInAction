package com.laurentiuspilca.ssia;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ProjectConfigurationIT {
	
	@Autowired
	UserDetailsService service;
	
	@Test
	public void sholdExist() throws UsernameNotFoundException {
		String userName = "Stein";
		UserDetails details = service.loadUserByUsername(userName);
		assertEquals( details.getUsername(),userName);
	}
	
	@Test
	public void sholdNotExist() {
		String userName = "Anne";
		 assertThrows(UsernameNotFoundException.class, () -> {
			 UserDetails details = service.loadUserByUsername(userName);
		});
	}

}
