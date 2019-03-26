package com.tricon.graphqlcontroller.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tricon.graphqlcontroller.dao.BookRepository;
import com.tricon.graphqlcontroller.model.Book;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Component
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	 @GraphQLQuery(name= "getBooks")
	public List<Book> getBooks(){
		 System.out.println("Anupama");
		return bookRepository.findAll();
	}
	 @GraphQLQuery(name= "getBooksByName")
	 public List<Book> getBooksByName(@GraphQLArgument(name = "name") String name){
		 return bookRepository.findByName(name);
	 }
	 
	 @GraphQLQuery(name= "getFirstNBooks")
	 public List<Book> getFirstNBooks(@GraphQLArgument(name = "count") int count){
		 return bookRepository.findAll().stream().limit(count).collect(Collectors.toList());
	 }
	 
	 @GraphQLQuery(name= "getBooksByAuthorId")
	 public List<Book> getBooksByAuthorId(@GraphQLArgument(name = "authorId") int authorId){
		 return bookRepository.findByAuthorId(authorId);
	 }
	 @GraphQLMutation(name = "createBooks")
	 public Book createBooks(@GraphQLArgument(name = "id") int id, @GraphQLArgument(name = "name") String name,@GraphQLArgument(name = "publisher") String publisher) {
		 Book book = new Book();
		 book.setId(id);
		 book.setName(name);
		 book.setPublisher(publisher);
		 bookRepository.save(book);
		 return book;
	 }
	 
	 
	 
	 public void deleteBook(@GraphQLArgument(name = "id") int id) {
		 bookRepository.delete(id);
	 }
}
