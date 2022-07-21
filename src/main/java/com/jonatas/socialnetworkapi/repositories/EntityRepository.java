package com.jonatas.socialnetworkapi.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.jonatas.socialnetworkapi.entities.Entity;

@Repository
public interface EntityRepository extends MongoRepository<Entity, String>{

	@Query("{ 'name' : { $regex: ?0, $options: 'i' } }")
	public List<Entity> searchByName(String text);
}
