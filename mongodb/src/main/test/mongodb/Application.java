package mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.DB;
import com.mongodb.MongoClient;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private CustomerRepository repository;
	
	public void run(String... arg0) throws Exception {

		MongoClient client = new MongoClient();
		DB db = client.getDB("test");
		
		System.out.println("connect successfully");
		
		repository.deleteAll();
		
		repository.save(new Customer("zj", "lihai"));
		repository.save(new Customer("zjj","lihai"));
		
		for(Customer customer : repository.findAll()){
			System.out.println(customer);
		}
		
		System.out.println();
		
		System.out.println(repository.findByFirstName("zj"));
		
		for (Customer customer : repository.findByLastName("lihai")) {
			System.out.println(customer);
		}
		
	}
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}

}
