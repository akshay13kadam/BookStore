package com.tech.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.store.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
