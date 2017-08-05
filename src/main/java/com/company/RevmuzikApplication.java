package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class RevmuzikApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevmuzikApplication.class, args);

	}
	
	/*
	 * 3. override the method configure to deploy a war file
	 * 
	 * The SpringBootServeletInitializer taps into a Servlet 3 <br>
	 * Programmatically defines a description of web.xml file
	 */

	private static Class<RevmuzikApplication> applicationClass = RevmuzikApplication.class;

	//@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(applicationClass);
	}

}
