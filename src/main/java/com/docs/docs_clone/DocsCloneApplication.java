package com.docs.docs_clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.docs.docs_clone.Controller","com.docs.docs_clone.Configure"})
public class DocsCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocsCloneApplication.class, args);
	}

}
