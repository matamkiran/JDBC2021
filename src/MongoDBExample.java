import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db=mongoClient.getDatabase("mymongodb");
	System.out.println(db.getName());
	}

}
