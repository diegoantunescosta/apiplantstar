 package com.jonatas.socialnetworkapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jonatas.socialnetworkapi.entities.dto.EditionDTO;
import com.jonatas.socialnetworkapi.entities.dto.EntityDTO;
import com.jonatas.socialnetworkapi.services.EntityService;

@RestController
@RequestMapping(value = "/entities")
public class EntityController {

	@Autowired
	private EntityService entityService;
	
	//get
	
	@GetMapping(value = "get/entities")
	public ResponseEntity<Object> findAllMini(){
		return entityService.findAllMini();
	}
	
	@GetMapping(value = "get/entity/{id}")
	public ResponseEntity<Object> findByIdMini(@PathVariable String id){
		return entityService.findByIdMini(id);
	}
			
	@GetMapping(value = "get/entity/{id}/entitysaves")
	public ResponseEntity<Object> getAllEntitySaveMini(@PathVariable String id){
		return entityService.getAllEntitySaveMini(id);
	}
	
	@GetMapping(value = "get/entity/{idEntity}/entitysave/user/{idUser}")
	public ResponseEntity<Object> getEntitySaveMini(@PathVariable String idEntity, @PathVariable String idUser ){
		return entityService.getEntitySaveMini(idEntity, idUser);
	}
	
	@GetMapping(value = "get/entity/{id}/editions")
	public ResponseEntity<Object> getEditionsMini(@PathVariable String id){
		return entityService.getEditionsMini(id);
	}
	
	@GetMapping(value = "get/entities/name")
	public ResponseEntity<Object> findByName(@RequestParam(value = "name", defaultValue = "") String name){
		return entityService.findByName(name);
	}
	
	@GetMapping(value = "get/reviews/{idEntity}/user/{idUser}")
	public ResponseEntity<Object> getReviewMini(@PathVariable String idEntity, @PathVariable String idUser){
		return entityService.getReviewMini(idEntity, idUser);
	}
	
	//post
	
	@PostMapping(value = "/post/entity/user/{id}")
	public ResponseEntity<Object> createEntity(@RequestBody EntityDTO entityDTO, @PathVariable String id){
		return entityService.createEntity(entityDTO, id);
		
	}
	
	//put
	
	@PutMapping(value = "put/name")
	public ResponseEntity<Void> updateName(@RequestBody EditionDTO editionDTO){
		return entityService.updateName(editionDTO);
	}
		
	@PutMapping(value = "put/description")
	public ResponseEntity<Void> updateDescription(@RequestBody EditionDTO editionDTO){
		return entityService.updateDescription(editionDTO);
	}
	
	@PutMapping(value = "put/add/image")
	public ResponseEntity<Void> addImage(@RequestBody EditionDTO editionDTO){
		return entityService.addImage(editionDTO);
	}
	
	@PutMapping(value = "put/remove/image")
	public ResponseEntity<Void> removeImage(@RequestBody EditionDTO editionDTO){
		return entityService.removeImage(editionDTO);
	}
}
