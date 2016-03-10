package com.papafranku.rest.api.users;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.papafranku.entities.Credentials;
import com.papafranku.entities.ResponseStatus;
import com.papafranku.entities.User;
import com.papafranku.rest.BaseController;
import com.papafranku.utilities.WebUtilities;

@RestController
@RequestMapping("/api/users")
public class AuthenticationController extends BaseController{
	
	public AuthenticationController() {
		
	}
	
	@RequestMapping(value = "/test", method = {RequestMethod.GET})
	public ResponseEntity<ResponseStatus> test(
            //@RequestBody Credentials credentials, 
            HttpServletRequest request,
            HttpServletResponse response) {
		
		List test = new ArrayList<String>();
		
		test.add("String 1");
		test.add("Fus Ro Dah");
		test.add("Niqquh");
		
		
		return WebUtilities.getResponse(new ResponseStatus(3L, test));
	
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<ResponseStatus> login(
            @RequestBody Credentials credentials, 
            HttpServletRequest request,
            HttpServletResponse response) {
		
		User user = null;
		
		try {
			System.out.println("Someone tried to login" + credentials);

			if (credentials == null) {
				return WebUtilities.getResponse(new ResponseStatus("Sorry, there are no credentials given."));
			}
			
			if (credentials.getUsername().equals("Ethan")) {
				
				if (credentials.getPassword().equals("test1234")) {
					
					user = new User();
					
					user.setLastName("Sonza");
					user.setFirstName("Ethan");
					user.setId(109L);
					user.setActive(true);
					user.setEmail("ethan@gmail.com");
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if (WebUtilities.isEmpty(user)) {
			return WebUtilities.getResponse(new ResponseStatus("Incorrect username or password"));
		}
		
		else {
			ResponseStatus status = null;
			
			status = user;
			
			return WebUtilities.getResponse(status);
		}
		
		
	
	}

}
