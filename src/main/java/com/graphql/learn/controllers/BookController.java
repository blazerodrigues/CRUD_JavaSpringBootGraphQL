package com.graphql.learn.controllers;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @MutationMapping("createBook")
    public Book create(@Argument BookInput bookInput){
        Book book = Book.builder().title(bookInput.getTitle()).desc(bookInput.getDesc()).author(bookInput.getAuthor()).price(bookInput.getPrice()).pages(bookInput.getPages()).build();
        return this.bookService.createOrUpdate(book);
    }
    @QueryMapping("allBooks")
    public List<Book> getAll(){
        return this.bookService.getAll();
    }
    @QueryMapping("getBook")
    public Book get(@Argument int bookId){
        return this.bookService.get(bookId);
    }

    @MutationMapping("updateBook")
    public Book update(@Argument BookInput bookInput){
        Book book = Book.builder().id(bookInput.getId()).title(bookInput.getTitle()).desc(bookInput.getDesc()).author(bookInput.getAuthor()).price(bookInput.getPrice()).pages(bookInput.getPages()).build();
        return this.bookService.createOrUpdate(book);
    }

    @MutationMapping("deleteBook")
    public String deleteBookById(@Argument Integer bookId){
        this.bookService.deleteById(bookId);
        return "BookId "+bookId+" is deleted.";
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class BookInput{
    private Integer id;
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}
