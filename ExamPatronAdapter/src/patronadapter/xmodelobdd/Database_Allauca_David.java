package patronadapter.xmodelobdd;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Database_Allauca_David {
	private static Database_Allauca_David instance = null;
	private MongoClient client;
	private MongoDatabase database;
	
	private Database_Allauca_David() {
		client = MongoClients.create("mongodb://localhost:27017");
		
		database = client.getDatabase("ExamPatronAdapter");
	}
	
	public static Database_Allauca_David getInstance() {
		if (instance == null)
			instance = new Database_Allauca_David();
		
		return instance;
	}
	
	public MongoDatabase getDatabase() {
		return database;
	}
}
