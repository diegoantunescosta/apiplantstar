package com.jonatas.socialnetworkapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonatas.socialnetworkapi.services.FollowerService;

@RestController
@RequestMapping(value = "/followers")
public class FollowerController {

	@Autowired
	private FollowerService followerService;
	
	//get
	
	@GetMapping(value = "get/followers")
	public ResponseEntity<Object> findAllMini(){
		return followerService.findAllMini();
	}
	
	@GetMapping(value = "get/follower/{id}")
	public ResponseEntity<Object> findByIdMini(@PathVariable String id){
		return followerService.findByIdMini(id);
	}
	
	@GetMapping(value = "get/followings/user/{userId}")
	public ResponseEntity<Object> getAllFollowingMini(@PathVariable String userId){
		return followerService.getAllFollowingMini(userId);
	}
	
	@GetMapping(value = "get/followers/user/{userId}")
	public ResponseEntity<Object> getAllFollowerMini(@PathVariable String userId){
		return followerService.getAllFollowerMini(userId);
	}
	
	@GetMapping(value = "get/check/following/user/{followerId}/following/{followingId}")
	public ResponseEntity<Object> CheckFollowing(@PathVariable String followerId, @PathVariable String followingId){
		return followerService.CheckFollowing(followerId, followingId);
	}
	
	//post
	
	@PostMapping(value = "post/follower/{followerId}/following/{followingId}")
	public ResponseEntity<Void> addFollowing(@PathVariable String followerId, @PathVariable String followingId){
		return followerService.addFollowing(followerId, followingId);
	}
	
	//delete
	
	@DeleteMapping(value = "delete/follower/{followerId}/following/{followingId}")
	public ResponseEntity<Void> removeFollowing(@PathVariable String followerId, @PathVariable String followingId){
		return followerService.removeFollowing(followerId, followingId);
	}
}
