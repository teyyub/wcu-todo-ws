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
		Todo t1 = new Todo("desc 1" , "note 1");
		Todo t2 = new Todo("desc 2" , "note 2");

		String url = "localhost:8082/api/todos";

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(String.valueOf(t1)))
				.build();

	}
}
