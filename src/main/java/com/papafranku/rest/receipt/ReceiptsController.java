package com.papafranku.rest.receipt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.papafranku.database.MongoAdapter;
import com.papafranku.database.MongoQueryBuilder;
import com.papafranku.database.MongoUtilities;
import com.papafranku.entities.Credentials;
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
			count = receipts.size();
			
			
		} catch(Exception e) {
			e.printStackTrace();
			return WebUtilities.getResponse(new ResponseStatus(500, "An error occured" + e.getMessage()));
		}
		
		return WebUtilities.getResponse(new ResponseStatus(count, receipts));
	
	}
	
	@RequestMapping(value = "/customer/{username}", method = {RequestMethod.POST})
	public ResponseEntity<ResponseStatus> addReceipt(
			@PathVariable String username,
			@RequestBody Receipt receipt,
            HttpServletRequest request,
            HttpServletResponse response) {
		
		if (WebUtilities.isEmpty(receipt)) {
			return WebUtilities.getResponse(new ResponseStatus(400, "There was no receipt input"));
		}
		
		if (WebUtilities.isEmpty(username)) {
			return WebUtilities.getResponse(new ResponseStatus(400, "Please specify the username"));
		}
		
		try {
			
			MongoQueryBuilder builder = new MongoQueryBuilder();
			Document doc = builder.queryData(MongoQueryBuilder.USER_COLLECTION, "username", username);
			
			if (WebUtilities.isEmpty(doc)) {
				return WebUtilities.getResponse(new ResponseStatus(400, "No such user exists"));
			}
			
			Receipt finalReceipt = new Receipt(username, receipt.getIssuer(), receipt.getId(),
					receipt.getVatRegTin(), receipt.getPn(), receipt.getSerialNumber(), receipt.getItems(),
					receipt.getAmountPaid(), receipt.getVatPercent());
			
			Document recDoc = MongoUtilities.convert(finalReceipt);
			builder.insertData(MongoQueryBuilder.RECEIPT_COLLECTION, recDoc);
			
		} catch(Exception e) {
			e.printStackTrace();
			return WebUtilities.getResponse(new ResponseStatus(500, "An error occured" + e.getMessage()));
		}
		
		return WebUtilities.getResponse(new ResponseStatus(200, "Successfully added receipt"));
	
	}

}
