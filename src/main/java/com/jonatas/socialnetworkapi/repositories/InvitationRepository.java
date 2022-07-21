package com.jonatas.socialnetworkapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jonatas.socialnetworkapi.entities.Invitation;

@Repository
public interface InvitationRepository extends MongoRepository<Invitation, String>{

	public Invitation findByValue(String value);
}
