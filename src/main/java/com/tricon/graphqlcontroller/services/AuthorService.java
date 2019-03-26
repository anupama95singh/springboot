package com.tricon.graphqlcontroller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tricon.graphqlcontroller.dao.AuthorRepository;
import com.tricon.graphqlcontroller.model.Author;

import io.leangen.graphql.annotations.GraphQLQuery;

@Component
public class AuthorService {

    @Autowired
	AuthorRepository authorRepository;
	
	@GraphQLQuery(name= "getAuthors")
	public List<Author> getAuthors(){
		return authorRepository.findAll();
	}
}
