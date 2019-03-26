package com.tricon.graphqlmongo.dao;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tricon.graphqlmongo.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String>{
	
//	public List<Book> deleteByName(String name);
	public List<Book> findByName(String name);
	public List<Book> findByAuthorAuthorId(String authorId);
	public List<Book> deleteByName(String name);
}
