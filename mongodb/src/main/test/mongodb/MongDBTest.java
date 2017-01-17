package mongodb;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongDBTest {

	public static void main(String[] arg0){
		
		MongoClient client;
		try {
			client = new MongoClient("localhost", 9927);
			DB db = client.getDB("test");
			
			System.out.println("connect successfully");
			db.slaveOk();
			DBCollection collections = db.getCollection("users");
			DBObject object = collections.findOne();
			
			String name = (String) object.get("username");
			Double age = (Double) object.get("age");
			
			System.out.println(name + "--" + age);
			
			DBCursor cursor = collections.find();
			
			List<DBObject> objects = cursor.toArray();
			for(DBObject dbo : objects){
				System.out.println(dbo.toString());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		
		
	}
	
}
