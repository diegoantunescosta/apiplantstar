package com.jonatas.socialnetworkapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jonatas.socialnetworkapi.entities.Report;

@Repository
public interface ReportRepository extends MongoRepository<Report, String>{

}
