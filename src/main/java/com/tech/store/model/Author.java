package com.tech.store.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author implements Serializable{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String email;
	@Column
	private String firstName;
	@Column
	String lastName;
	@Column
	String userName;
	//@Column
	//private Contact contact;
	
	
//	 @OneToMany(mappedBy = "author", fetch = FetchType.LAZY,
//	            cascade = CascadeType.ALL)
//	
//	 private List<Book> books = new ArrayList<>();
	 

	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	    private List<Book> books = new ArrayList<>();
	
	
	
	public Long getLong() {
		return id;
	}
	public void setLong(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
//	public Contact getContact() {
//		return contact;
//	}
//	public void setContact(Contact contact) {
//		this.contact = contact;
//	}


	public Author() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}



}
