package com.tricon.graphqlcontroller.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tricon.graphqlcontroller.services.AuthorService;
import com.tricon.graphqlcontroller.services.BookService;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
@RestController
public class Controller {
	
	 private final GraphQL graphQL;

	 	@Autowired
	    public Controller(BookService bookService, AuthorService authorService) {
	 		
	        GraphQLSchema schema = new GraphQLSchemaGenerator()
	                .withResolverBuilders(
	                        //Resolve by annotations
	                        new AnnotatedResolverBuilder(),
	                        new PublicResolverBuilder("com.tricon.graphqlcontroller"))
	                .withOperationsFromSingleton(bookService)
	                .withOperationsFromSingleton(authorService)
	                .withValueMapperFactory(new JacksonValueMapperFactory())
	                .generate();
	        graphQL = GraphQL.newGraphQL(schema).build();
	    }

	    @PostMapping(value = "/graphql")
	    @ResponseBody
	    public Map<String, Object> graphql(@RequestBody Map<String, String> request) {
	        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
	        		                             .query(request.get("query"))
//	        		                             .operationName(request.get("operationName"))
	        		                             .build()
	        		                             );   
//	    	ExecutionResult executionResult = graphQL.execute("{getBooks {name}}");   
	        return executionResult.getData();
	    }
	
//	 public void buildSchema() {
//		 BookService bookService = new BookService();
//		 GraphQLSchema schema = new GraphQLSchemaGenerator()
//				                    .withOperationsFromSingleton(bookService)
//				                    .generate();
//		 
//		 GraphQL graphQL = new GraphQL(schema);
//		 
//		 String query ="{ books{ name }}";
//		 
//		 ExecutionResult result = graphQL.execute(query);
//		 
//	 }
	
}
