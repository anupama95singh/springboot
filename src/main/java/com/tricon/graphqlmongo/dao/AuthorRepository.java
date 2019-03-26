package com.tricon.graphqlmongo.dao;




import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tricon.graphqlmongo.model.Author;


@Repository
public interface AuthorRepository extends MongoRepository<Author, String>{

}
