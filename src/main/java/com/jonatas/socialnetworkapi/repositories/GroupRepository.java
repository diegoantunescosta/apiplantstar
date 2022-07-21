package com.jonatas.socialnetworkapi.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.jonatas.socialnetworkapi.entities.Group;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {

	@Query("{ 'name' : { $regex: ?0, $options: 'i' } }")
	public List<Group> searchByName(String text);
}
