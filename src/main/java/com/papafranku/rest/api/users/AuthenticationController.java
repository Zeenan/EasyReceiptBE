package com.papafranku.rest.api.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.papafranku.entities.Credentials;
import com.papafranku.entities.ResponseStatus;

@RestController
@RequestMapping("/api/users")
public class AuthenticationController {
	
	public AuthenticationController() {
		
	}
	
	@RequestMapping(value = "/auth", method = {RequestMethod.POST, RequestMethod.OPTIONS})
	public ResponseEntity<ResponseStatus> login(
            @RequestBody Credentials credentials, 
            HttpServletRequest request,
            HttpServletResponse response) {
		
		
		
		return null;
	
	}

}
