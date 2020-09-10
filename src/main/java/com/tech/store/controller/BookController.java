package com.tech.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tech.store.model.Book;
import com.tech.store.repository.AuthorRepository;
import com.tech.store.repository.BookRepository;

@RestController
public class BookController {

	
	  @Autowired
	    private BookRepository bookRepository;
	  
	  
	  @Autowired
	    private AuthorRepository authorRepository;
	  
	  
	  
	  @GetMapping("/books/{bookId}/books")
	    public List < Book > getBookByAuthor(@PathVariable(value = "postId") Long bookId) {
	        return bookRepository.findAll();
	    }
}
