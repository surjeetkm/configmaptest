package com.c2p.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private Environment env;
	@Value("${test.message:default test message}")
	private String message;
	@Value("${mypassword:default password}")
	private String password;
	
	@GetMapping
	public String test() {
		String prefix = System.getenv().getOrDefault("CONFIG_MESSAGE", "Hi");
		System.out.println(prefix);
		System.out.println("Hello Welcome!");
		return String.format(message, prefix);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/getmsg")
	public String sayHello() {
		String message=env.getProperty("test.message");
		String username=env.getProperty("test.username");
		String pswrd=env.getProperty("test.password");
		System.out.println("Username: "+message);
		System.out.println("Firstname:"+username);
		System.out.println("User Password:"+ pswrd);
		return "Swagger Hello World"+ message;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/getpassword")
	public String saypasswordFromSecret() {
		String password=env.getProperty("mypassword");
		String pswrd=env.getProperty("test.mypassword");
		System.out.println("MyPassword:"+ pswrd);
		return password;
	}
}