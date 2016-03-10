package com.papafranku.rest.receipt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.papafranku.database.MongoAdapter;
import com.papafranku.database.MongoQueryBuilder;
import com.papafranku.entities.Receipt;
import com.papafranku.entities.ResponseStatus;
import com.papafranku.entities.User;
import com.papafranku.rest.BaseController;
import com.papafranku.utilities.WebUtilities;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptsController extends BaseController{
	
	@RequestMapping(value = "/secret/initreceipts", method = {RequestMethod.GET})
	public ResponseEntity<ResponseStatus> initusers(
            HttpServletRequest request,
            HttpServletResponse response) {
		
		try {
			
			MongoAdapter adapter = new MongoAdapter();
			adapter.connect();
			adapter.seedReceipts();
			
			return WebUtilities.getResponse(new ResponseStatus(200, "Successfully seeded db"));
			
		} catch(Exception e) {
			
			e.getMessage();
			return WebUtilities.getResponse(new ResponseStatus(500, "An error occured"));
		}
	
	}
	
	@RequestMapping(value = "/customer/{username}", method = {RequestMethod.GET})
	public ResponseEntity<ResponseStatus> listUsers(
			@PathVariable String username,
            HttpServletRequest request,
            HttpServletResponse response) {
		
		List<Receipt> receipts;
		long count = 0;
		
		try {
			
			MongoQueryBuilder builder = new MongoQueryBuilder();
			receipts = builder.getReceipts(username);
			
			
		} catch(Exception e) {
			e.printStackTrace();
			return WebUtilities.getResponse(new ResponseStatus(500, "An error occured" + e.getMessage()));
		}
		
		return WebUtilities.getResponse(new ResponseStatus(count, receipts));
	
	}

}
