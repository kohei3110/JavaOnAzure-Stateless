package com.kohei3110.javaonazurestatelessdemo;

// import com.kohei3110.javaonazurestatelessdemo.StatelessSession.Factory;
import com.kohei3110.javaonazurestatelessdemo.StatelessSession.model.Todo;
import com.kohei3110.javaonazurestatelessdemo.StatelessSession.repository.CrudItemRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@SpringBootApplication
@ComponentScan("{com.kohei3110.javaonazureblobdemo.StatelessSession}")
public class Controller {

	private final CrudItemRepository repository;

	public Controller(CrudItemRepository repository) {
		this.repository = repository;
	}
	// Factory factory = new Factory();

	public static void main(String[] args) {
		SpringApplication.run(Controller.class, args);
	}

	@GetMapping("/")
	public Iterable<Todo> findAllTodos() {
		return repository.findAll();
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Todo createTodo(@RequestBody Todo item) {
		return repository.save(item);
	}

}