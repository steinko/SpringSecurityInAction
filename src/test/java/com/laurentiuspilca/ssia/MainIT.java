package com.laurentiuspilca.ssia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.web.server.LocalServerPort;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.web.context.WebApplicationContext;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class MainIT {
	
	 @LocalServerPort
	 private  int localServerPort;
	 
	 @Autowired
	  private WebApplicationContext webApplicationContext;
	
	
	 @Test
     public void shouldbeUnautorised()  {
    	 
    	 
    	 String url =  "http://localhost:" + localServerPort + "/hello";	
    	 
    	 given().
          webAppContextSetup(webApplicationContext)
        .when()
           .get(url)
        .then()
          .statusCode(UNAUTHORIZED.value()); 
     
     }
	 
	 
	 @Test
     public void shouldAutorise()  {
    	 
    	 
    	 String url =  "http://localhost:" + localServerPort + "/hello";	
    	 
    	 given()
    	  .auth().with(SecurityMockMvcRequestPostProcessors.httpBasic("Stein", "12345"))
          .webAppContextSetup(webApplicationContext)
        .when()
           .get(url)
        .then()
          .statusCode(OK.value()); 
     
     }

}
