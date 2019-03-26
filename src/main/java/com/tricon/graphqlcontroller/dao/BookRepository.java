package com.tricon.graphqlcontroller.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tricon.graphqlcontroller.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	List<Book> findByName(String name);
	List<Book> findByAuthorId(int authorId);
}
