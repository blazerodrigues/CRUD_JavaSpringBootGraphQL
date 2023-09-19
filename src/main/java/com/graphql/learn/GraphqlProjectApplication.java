package com.graphql.learn;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlProjectApplication implements CommandLineRunner {
	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1 = Book.builder().title("Java Book").desc("For learning Java").pages(2000).price(3000).author("ABC").build();
		Book b2 = Book.builder().title("Python Book").desc("For learning Python").pages(3000).price(4000).author("DEF").build();
		Book b3 = Book.builder().title("JavaScript Book").desc("For learning JavaScript").pages(4000).price(5000).author("GHI").build();
		this.bookService.createOrUpdate(b1);
		this.bookService.createOrUpdate(b2);
		this.bookService.createOrUpdate(b3);
	}
}
