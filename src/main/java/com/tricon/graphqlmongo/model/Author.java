package com.tricon.graphqlmongo.model;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "authors")
public class Author {

	
 	@Id
	private String  authorId;
	
	private String firstName;
	
	private String lastName;
	public String  getId() {
		return authorId;
	}
	public void setId(String  authorId) {
		this.authorId = authorId;
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
	public Author(String  authorId, String firstName, String lastName) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Author() {
		super();
	}
	
}
