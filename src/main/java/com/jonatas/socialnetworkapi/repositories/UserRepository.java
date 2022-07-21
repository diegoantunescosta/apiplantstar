package com.jonatas.socialnetworkapi.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.jonatas.socialnetworkapi.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	public User findByEmail(String email);
	
	@Query("{ 'name' : { $regex: ?0, $options: 'i' } }")
	public List<User> searchByName(String text);
	
}
