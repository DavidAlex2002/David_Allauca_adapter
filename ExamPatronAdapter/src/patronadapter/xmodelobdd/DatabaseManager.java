package patronadapter.xmodelobdd;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DatabaseManager {
	private static DatabaseManager instance = null;
	private MongoClient client;
	private MongoDatabase database;
	
	private DatabaseManager() {
		client = MongoClients.create("mongodb://localhost:27017");
		
		database = client.getDatabase("ExamPatronAdapter");
	}
	
	public static DatabaseManager getInstance() {
		if (instance == null)
			instance = new DatabaseManager();
		
		return instance;
	}
	
	public MongoDatabase getDatabase() {
		return database;
	}
}
