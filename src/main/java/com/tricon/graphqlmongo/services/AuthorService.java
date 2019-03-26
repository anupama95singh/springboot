package com.tricon.graphqlmongo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tricon.graphqlmongo.dao.AuthorRepository;
import com.tricon.graphqlmongo.model.Author;


import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Component
public class AuthorService {

    @Autowired
	AuthorRepository authorRepository;
	
	@GraphQLQuery(name= "getAuthors")
	public List<Author> getAuthors(){
		return authorRepository.findAll();
	}
	
	 @GraphQLMutation(name = "createAuthors")
	 public Author createAuthors(@GraphQLArgument(name = "authorId") String  authorId, @GraphQLArgument(name = "firstName") String firstName,@GraphQLArgument(name = "lastName") String lastName) {
		 Author author = new Author();
		 author.setId(authorId);
		 author.setFirstName(firstName);
		 author.setLastName(lastName);
		 authorRepository.save(author);
		 return author;
	 }
}
