package com.tricon.graphqlcontroller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tricon.graphqlcontroller.model.Author;
import com.tricon.graphqlcontroller.model.Book;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

//	List<Book> findByName(String name);
}
