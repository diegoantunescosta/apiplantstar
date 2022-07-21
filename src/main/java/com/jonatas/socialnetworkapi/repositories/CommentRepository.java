package com.jonatas.socialnetworkapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jonatas.socialnetworkapi.entities.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String>{

}
