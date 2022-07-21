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

import com.jonatas.socialnetworkapi.entities.dto.CommentDTO;
import com.jonatas.socialnetworkapi.services.CommentService;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

	//services
	
	@Autowired
	private CommentService commentService;
	
	//get
	
	@GetMapping(value = "get/comments")
	public ResponseEntity<Object> findAll(){
		return commentService.findAllMini();
	}
	
	@GetMapping(value = "get/comment/{id}")
	public ResponseEntity<Object> findById(@PathVariable String id){
		return commentService.findByIdMini(id);
	}
	
	//post
	@PostMapping(value = "post/comment")
	public ResponseEntity<Object> newComment(@RequestBody CommentDTO commentDTO){
		return commentService.newComment(commentDTO);
	}
	
	@PostMapping(value = "post/comment/entitysave")
	public ResponseEntity<Object> newCommentEntitySave(@RequestBody CommentDTO commentDTO){
		return commentService.newCommentEntitySave(commentDTO);
	}
	
	//put
	@PutMapping(value = "put/like/comment/{idComment}/user/{idUser}")
	public ResponseEntity<Object> addLike(@PathVariable String idUser, @PathVariable String idComment){
		return commentService.addLike(idUser, idComment);
	}
	
	//delete
	@DeleteMapping(value = "delete/comment")
	public ResponseEntity<Object> deleteComment(@RequestBody CommentDTO commentDTO){
		return commentService.deleteComment(commentDTO);
	}
	
	@DeleteMapping(value = "delete/comment/entitysave")
	public ResponseEntity<Object> deleteCommentEntitySave(@RequestBody CommentDTO commentDTO){
		return commentService.deleteCommentEntitySave(commentDTO);
	}
	
}
