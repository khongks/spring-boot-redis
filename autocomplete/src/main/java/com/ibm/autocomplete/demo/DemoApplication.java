package com.ibm.autocomplete.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@EnableCaching
@SpringBootApplication

public class DemoApplication {

	@Autowired
	AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
*/

@EnableCaching
@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	 
	@Autowired
	CustomerRepository addressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	 
	@Override
	public void run(String... arg0) throws Exception {
		// initial data to PostGreSQL database 
		//addressRepository.save(Arrays.asList(new Address("1", "Jack", "Smith"), 
		//									new Customer("2", "Adam", "Johnson")));
	}
}