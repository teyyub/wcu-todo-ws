package com.example.todo;

import com.example.todo.controllers.Todo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpRequest;

@SpringBootApplication
public class WcuTodoWsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WcuTodoWsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("welcome wcu todo web service");
	}
}
