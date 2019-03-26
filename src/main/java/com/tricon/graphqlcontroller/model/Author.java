package com.tricon.graphqlcontroller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.leangen.graphql.annotations.GraphQLQuery;

@Entity
@Table(name = "author_details")
public class Author {

	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Id
	private int authorId;
	@GraphQLQuery(name = "firstName", description = "A  name")
	private String firstName;
	@GraphQLQuery(name = "lastName", description = "A  name")
	private String lastName;
	public int getId() {
		return authorId;
	}
	public void setId(int authorId) {
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
	public Author(int authorId, String firstName, String lastName) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Author() {
		super();
	}
	
}
