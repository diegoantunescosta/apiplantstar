package com.jonatas.socialnetworkapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonatas.socialnetworkapi.entities.Edition;
import com.jonatas.socialnetworkapi.services.EditionService;

@RestController
@RequestMapping(value = "/editions")
public class EditionController {

	@Autowired
	private EditionService editionService;
	
	//get
	
	@GetMapping(value = "get/editions")
	public ResponseEntity<Object> findAllMini(){
		return editionService.findAllMini();
	}
	
	@GetMapping(value = "get/edition/{id}")
	public ResponseEntity<Object> findByIdMini(@PathVariable String id){
		return editionService.findByIdMini(id);
	}
	
	//post
	
	@PostMapping(value = "post/edition")
	public ResponseEntity<Object> newEdition(@RequestBody Edition edition){
		return editionService.newEdition(edition);
	}
}
