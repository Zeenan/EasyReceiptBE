package com.papafranku.rest.api.users;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.papafranku.database.MongoAdapter;
import com.papafranku.database.MongoQueryBuilder;
import com.papafranku.database.MongoUtilities;
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
	
	@RequestMapping(value = "/admin/listusers", method = {RequestMethod.GET})
	public ResponseEntity<ResponseStatus> listUsers(
            HttpServletRequest request,
            HttpServletResponse response) {
		
		List<User> users;
		long count = 0;
		
		try {
			
			MongoQueryBuilder builder = new MongoQueryBuilder();
			users = builder.getUsers();
			count = users.size();
			
		} catch(Exception e) {
			e.printStackTrace();
			return WebUtilities.getResponse(new ResponseStatus(500, "An error occured" + e.getMessage()));
		}
		
		return WebUtilities.getResponse(new ResponseStatus(count, users));
	
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
		
		if (WebUtilities.isEmpty(credentials)) {
			WebUtilities.getResponse(new ResponseStatus(500 ,"No Credentials Given"));
		}
		
		try {
		
			MongoQueryBuilder builder = new MongoQueryBuilder();
			Document doc = builder.queryData(MongoQueryBuilder.USER_COLLECTION, "username", credentials.getUsername());
			
			//builder.getUser("ethanSonza");
			
			if (WebUtilities.isEmpty(doc)) {
				return WebUtilities.getResponse(new ResponseStatus(401, "Invalid username or password"));
			}
			user = MongoUtilities.getUser(doc);
			
			if (!credentials.getPassword().equals(user.getPassword())) {
				return WebUtilities.getResponse(new ResponseStatus(401, "Invalid username or password"));
			}
			
			//db.users.find('user.username', 'ethanSonza')
			System.out.println(user.getFirstName());
			user.setAuthenticity_token(credentials.getauthenticity_token());

			return WebUtilities.getResponse(user);
			
		} catch(Exception e) {
			e.printStackTrace();
			return WebUtilities.getResponse(new ResponseStatus(500 ,"An error occured."));
		}
	}
	
	@RequestMapping(value = "/secret/initusers", method = {RequestMethod.GET})
	public ResponseEntity<ResponseStatus> initusers(
            HttpServletRequest request,
            HttpServletResponse response) {
		
		try {
			
			MongoAdapter adapter = new MongoAdapter();
			adapter.connect();
			adapter.initializeUsers();
			
		} catch(Exception e) {
			return WebUtilities.getResponse(new ResponseStatus(500, "An error occured"));
		}
		
		return WebUtilities.getResponse(new ResponseStatus(200, "Successfully seeded db"));
	
	}

}
