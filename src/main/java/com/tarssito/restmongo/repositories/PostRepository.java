package com.tarssito.restmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tarssito.restmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
