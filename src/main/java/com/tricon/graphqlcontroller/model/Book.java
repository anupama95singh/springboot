package com.tricon.graphqlcontroller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.leangen.graphql.annotations.GraphQLQuery;
@Entity
@Table(name = "book_details")
public class Book {
	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Id
	private int id;
	 @GraphQLQuery(name = "name", description = "A  name")
	private String name;
	private String publisher;
	private int authorId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public Book(int id, String name, String publisher, int authorId) {
		super();
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.authorId = authorId;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", publisher=" + publisher + "]";
	}

	
	
}
