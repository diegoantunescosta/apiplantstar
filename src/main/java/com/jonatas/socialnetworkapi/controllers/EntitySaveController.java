package com.jonatas.socialnetworkapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonatas.socialnetworkapi.entities.dto.EntitySaveDTO;
import com.jonatas.socialnetworkapi.services.EntitySaveService;

@RestController
@RequestMapping(value = "/entitysaves")
public class EntitySaveController {

	//services
	
	@Autowired
	private EntitySaveService entitySaveService;
	
	//get
	
	@GetMapping(value = "get/entitysaves/user/{idUser}")
	public ResponseEntity<Object> findAllMini(@PathVariable String idUser){
		return entitySaveService.findAllMini(idUser);
	}
		
	@GetMapping(value = "get/entitysave/{idEntitySave}/user/{idUser}")
	public ResponseEntity<Object> findByIdMini(@PathVariable String idEntitySave, @PathVariable String idUser){
		return entitySaveService.findByIdMini(idEntitySave, idUser);
	}
	
	@GetMapping(value = "get/likes/{id}")
	public ResponseEntity<Object> getLikes(@PathVariable String id){
		return entitySaveService.getLikes(id);
	}
	
	@GetMapping(value = "get/comments/{idEntitySave}/user/{idUser}")
	public ResponseEntity<Object> getComments(@PathVariable String idEntitySave, @PathVariable String idUser){
		return entitySaveService.getCommentsMini(idEntitySave, idUser);
	}
	
	//post
	
	@PostMapping(value = "post/entity")
	public ResponseEntity<Object> newEntitySaveEntity(@RequestBody EntitySaveDTO entitySaveDTO){
		return entitySaveService.newEntitySaveEntity(entitySaveDTO);
	}
			
	//put
	@PutMapping(value = "put/category")
	public ResponseEntity<Object> updateEntitySaveCategory(@RequestBody EntitySaveDTO entitySaveDTO){
		return entitySaveService.updateEntitySaveCategory(entitySaveDTO);
	}
	
	@PutMapping(value = "put/evaluation")
	public ResponseEntity<Object> updateEntitySaveEvaluation(@RequestBody EntitySaveDTO entitySaveDTO){
		return entitySaveService.updateEntitySaveEvaluation(entitySaveDTO);
	}
	
	@PutMapping(value = "put/goal")
	public ResponseEntity<Object> updateEntitySaveGoal(@RequestBody EntitySaveDTO entitySaveDTO){
		return entitySaveService.updateEntitySaveGoal(entitySaveDTO);
	}
	
	@PutMapping(value = "put/review")
	public ResponseEntity<Object> updateEntitySaveReview(@RequestBody EntitySaveDTO entitySaveDTO){
		return entitySaveService.updateEntitySaveReview(entitySaveDTO);
	}
	
	@PutMapping(value = "put/like/entitysave/{idEntitySave}/user/{idUser}")
	public ResponseEntity<Object> updateLike(@PathVariable String idUser, @PathVariable String idEntitySave){
		return entitySaveService.updateLike(idUser, idEntitySave);
	}
	
	
	//delete
	
	@DeleteMapping(value = "delete/entity")
	public ResponseEntity<Object> deleteEntitySaveEntity(EntitySaveDTO entitySaveDTO){
		return entitySaveService.deleteEntitySaveEntity(entitySaveDTO);
	}
	
}
