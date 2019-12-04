/**
 * @author Akshay Moralwar
 * */
package com.example.crudoperations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudDemoApplication {
private static Logger logger =LoggerFactory.getLogger(CrudDemoApplication.class);
	/* Main method of the application which will be responsible to deploy the application. */
	public static void main(String[] args) {
		logger.info("starting application...");
		SpringApplication.run(CrudDemoApplication.class, args);
	}

}
