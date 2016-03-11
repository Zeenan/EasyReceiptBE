package com.papafranku.rest.api.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.papafranku.database.MongoQueryBuilder;
import com.papafranku.database.MongoUtilities;
import com.papafranku.entities.Receipt;
import com.papafranku.entities.ResponseStatus;
import com.papafranku.entities.User;
import com.papafranku.rest.BaseController;
import com.papafranku.utilities.WebUtilities;

@RestController
@RequestMapping("/api/users/registration")
public class RegistrationController extends BaseController {
	
	@RequestMapping(value = "/register", method = {RequestMethod.POST})
	public ResponseEntity<ResponseStatus> addReceipt(
			@RequestBody User user,
            HttpServletRequest request,
            HttpServletResponse response) {
		
		if (WebUtilities.isEmpty(user)) {
			return WebUtilities.getResponse(new ResponseStatus(400, "There was no receipt input"));
		}
		
		try {
			
			MongoQueryBuilder builder = new MongoQueryBuilder();
			Document doc = builder.queryData(MongoQueryBuilder.USER_COLLECTION, "username", user.getUsername());
			
			if (!WebUtilities.isEmpty(doc)) {
				return WebUtilities.getResponse(new ResponseStatus(400, "User already exists"));
			}
			
			
			
			Document userDoc = MongoUtilities.convert(user);
			builder.insertData(MongoQueryBuilder.USER_COLLECTION, userDoc);
			
		} catch(Exception e) {
			e.printStackTrace();
			return WebUtilities.getResponse(new ResponseStatus(500, "An error occured" + e.getMessage()));
		}
		
		return WebUtilities.getResponse(new ResponseStatus(200, "Successfully added receipt"));
	
	}

}
