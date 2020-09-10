package com.tech.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.store.model.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

	
	
}
