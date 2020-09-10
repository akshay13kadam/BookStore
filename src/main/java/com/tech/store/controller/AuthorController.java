package com.tech.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.store.model.Author;
import com.tech.store.repository.AuthorRepository;

@RestController
@RequestMapping("/api/v1")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    
    //Fetch all records 
    @GetMapping("/author")
    public List < Author > getAuthors() {
        return authorRepository.findAll();
    }
    
   // Create all records 
    @PostMapping("/author")
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

   //Fetch single record by id 
    @GetMapping("/author/{id}")
    public Optional<Author> getAuthorById(@PathVariable(value = "id") long authorId) {
    	
    	
    	return authorRepository.findById(authorId);
            //.orElseThrow(() - > new ResourceNotFoundException("User not found with id :" + authorId));
    }
     
    
    //Update single record	
    @PutMapping("/author/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") long id, @RequestBody Author author) {
      Optional<Author> authorData = authorRepository.findById(id);

      
      if (authorData.isPresent()) {
        Author _aAuthor = authorData.get();
        _aAuthor.setEmail(author.getEmail());
        _aAuthor.setFirstName(author.getFirstName());
        _aAuthor.setLastName(author.getLastName());
        _aAuthor.setUserName(author.getUserName());
        
        return new ResponseEntity<>(authorRepository.save(_aAuthor), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    //Delete single record by id
    @DeleteMapping("/author/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
      try {
        authorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
}
