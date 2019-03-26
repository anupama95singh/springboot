package com.tricon.graphqlmongo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "books")
public class Book {

 	@Id
	private String id;
	private String name;
	private String publisher;
//	private int  authorId;
	private Author author;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
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
//	public int  getAuthorId() {
//		return authorId;
//	}
//	public void setAuthorId(int  authorId) {
//		this.authorId = authorId;
//	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
//	public Book(String id, String name, String publisher, int  authorId) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.publisher = publisher;
//		this.authorId = authorId;
//	}
	public Book(String id, String name, String publisher, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.author = author;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", publisher=" + publisher + "]";
	}

	
	
}
