package com.tricon.graphqlmongo.services;

import java.util.List;

import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tricon.graphqlmongo.dao.AuthorRepository;
import com.tricon.graphqlmongo.dao.BookRepository;
import com.tricon.graphqlmongo.model.Author;
import com.tricon.graphqlmongo.model.Book;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Component
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorRepository authorRepository;
	
	 @GraphQLQuery(name= "getAll")
	public List<Book> getAll(){
		return bookRepository.findAll();
		}
	
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
	 public List<Book> getBooksByAuthorId(@GraphQLArgument(name = "authorId") String authorId){
		 System.out.println(authorId);
		 Book book = new Book();
		 System.out.println(authorRepository.findById(authorId));
		 book.setAuthor(authorRepository.findById(authorId).get());
		 System.out.println(book.getAuthor().getId());
		 return bookRepository.findByAuthorAuthorId(authorId);

	 }
	 
//	 @GraphQLMutation(name = "createBooks")
//	 public Book createBooks(@GraphQLArgument(name = "id") String id, @GraphQLArgument(name = "name") String name,@GraphQLArgument(name = "publisher") String publisher,@GraphQLArgument(name = "authorId") int  authorId ) {
//		 Book book = new Book();
////		 ObjectId objId = new ObjectId("authorId");
//		 book.setId(id);
//		 book.setName(name);
//		 book.setPublisher(publisher);
//		 book.setAuthorId(authorId);
//		 bookRepository.save(book);
//		 return book;
//	 }
	 
	 @GraphQLMutation(name = "createBooksAndAuthors")
	 public Book createBooksAndAuthors(@GraphQLArgument(name = "id") String id, @GraphQLArgument(name = "name") String name,@GraphQLArgument(name = "publisher") String publisher,@GraphQLArgument(name = "author") Author author  ) {
		 Book book = new Book();
		 book.setId(id);
		 book.setName(name);
		 book.setPublisher(publisher);
		 book.setAuthor(author);
		 bookRepository.save(book);
		 return book;
	 }
	 
	 @GraphQLMutation(name = "deleteAll")
	 public void deleteAll(@GraphQLArgument(name = "id") String id){
		 bookRepository.deleteById(id);
	 }
	 
	 @GraphQLMutation(name = "deleteByBookName")
	 public List<Book> deleteByBookName(@GraphQLArgument(name = "name") String name){
		return bookRepository.deleteByName(name);
	 }
	 
}
