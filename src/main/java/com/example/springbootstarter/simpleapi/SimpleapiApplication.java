package com.example.springbootstarter.simpleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleapiApplication {

        // This is where we are going to bootstrap our spring boot application, ie in this main method. Spring Boot creates a Spring
        // application that is standalone, doesn't need a servlet container, doesn't need to deploy in a server. The way its works
        // is by having a class with a main method that we can start just like any other java application. This main method takes care
        // of everything, starting a servlet container( tomcat ), host application in it.
        //
        // In order to achieve all these things there is 2 steps.
        //  1) @SpringBootApplication -- Annotation used to tell that this application () is a Spring application.
        //      This annotation tells that this is the starting point of this application.
        //  2) what about the content in the main method?
        //     we need to tell the spring to start the servlet and host application in it. This can be achieved by the following utility.
        //     These can be achieved by a static method 'run' in a static class 'SpringApplication'. run methods takes class of main
        //     method and args.
        // After completing this, application will be started at localhost:8080. Usually it gives a whitelabel error with status code 404.
        // This is due to there is no mapped url. The servlet tries to go to /error but that is also not present.(This application has no
        // explicit mapping for /error, so you are seeing this as a fallback.)
	public static void main(String[] args) {
		SpringApplication.run(SimpleapiApplication.class, args);
		// >> It set up the default configuration
		// >> starts tomcat.
		// >> Starts application Context.
		// >> Performs class path scan --
	}
	// In order to work properly without whitelabel error, we add controller. They are java class that has annotation marked in it.
	// This annotation says what is mapped with url and what block of code is to run when a request comes. ie
	//      >> what url can access it?
	//      >> What to run if accessed?
}
