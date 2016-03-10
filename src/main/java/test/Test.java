package test;

import java.util.List;

import com.papafranku.database.MongoAdapter;
import com.papafranku.database.MongoQueryBuilder;
import com.papafranku.entities.Receipt;

public class Test {
	
	public static void main(String[] args) {
		
		try {
		
		MongoAdapter adapter = new MongoAdapter();
		adapter.connect();
		adapter.seedReceipts(); // */
			
		/*MongoQueryBuilder b = new MongoQueryBuilder();
		
		List<Receipt> a = b.getReceipts("ethanSonza");
		
		for (Receipt r : a) {
			System.out.println(r.getAmountPaid());
		}
		//*/
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
