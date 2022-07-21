package com.jonatas.socialnetworkapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jonatas.socialnetworkapi.entities.dto.GroupDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.GroupMiniDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.UserMiniDTO;
import com.jonatas.socialnetworkapi.services.GroupService;

@RestController
@RequestMapping(value = "groups")
public class GroupController {

	@Autowired
	private GroupService groupService;
	
	//get
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<GroupMiniDTO>> getGroups(@PathVariable String id){
		try {
			//GroupMiniDTO groupMiniDTO = groupService.getGroup(idGroup, idUser);
			return ResponseEntity.status(HttpStatus.OK).body(groupService.getGroups(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(value = "/{idGroup}/{idUser}")
	public ResponseEntity<GroupMiniDTO> getGroup(@PathVariable String idGroup, @PathVariable String idUser){
		try {
			//GroupMiniDTO groupMiniDTO = groupService.getGroup(idGroup, idUser);
			return ResponseEntity.status(HttpStatus.OK).body(groupService.getGroup(idGroup, idUser));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(value = "/{idGroup}/members")
	public ResponseEntity<List<UserMiniDTO>> getMembers(@PathVariable String idGroup){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(groupService.getMembers(idGroup));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(value = "/{idGroup}/moderators")
	public ResponseEntity<List<UserMiniDTO>> getModerators(@PathVariable String idGroup){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(groupService.getModerators(idGroup));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(value = "/{idGroup}/silenced")
	public ResponseEntity<List<UserMiniDTO>> getMembersSilenced(@PathVariable String idGroup){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(groupService.getMembersSilenced(idGroup));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(value = "/name")
	public ResponseEntity<Object> findByName(@RequestParam(value = "name", defaultValue = "") String name){
		return groupService.findByName(name);
	}
	
	@GetMapping(value = "/group/{idGroup}/user/{idUser}/posts")
	public ResponseEntity<Object> getPostsGroup(@PathVariable String idGroup, @PathVariable String idUser){
		return groupService.getPostsGroup(idGroup, idUser);
	}
	
	//post
	
	@PostMapping
	public ResponseEntity<GroupMiniDTO> createGroup(@RequestBody GroupDTO groupDTO){
		try {
			//GroupMiniDTO groupMiniDTO = groupService.createGroup(groupDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(groupService.createGroup(groupDTO));
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//put
	
	@PutMapping(value = "{idGroup}/add/{idUser}")
	public ResponseEntity<GroupMiniDTO> enterGroup(@PathVariable String idGroup, @PathVariable String idUser){
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(groupService.enterGroup(idGroup, idUser));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value = "{idGroup}/remove/{idUser}")
	public ResponseEntity<GroupMiniDTO> goOutGroup(@PathVariable String idGroup, @PathVariable String idUser){
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(groupService.goOutGroup(idGroup, idUser));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value = "{idGroup}/{idCreator}/add/moderator/{idMember}")
	public ResponseEntity<GroupMiniDTO> addModerator(@PathVariable String idGroup, @PathVariable String idCreator, @PathVariable String idMember){
		try {
			boolean added = groupService.addModerator(idGroup, idCreator, idMember);
			if(added) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value = "{idGroup}/{idCreator}/remove/moderator/{idMember}")
	public ResponseEntity<GroupMiniDTO> removeModerator(@PathVariable String idGroup, @PathVariable String idCreator, @PathVariable String idMember){
		try {
			boolean added = groupService.removeModerator(idGroup, idCreator, idMember);
			if(added) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value = "silence/{idGroup}/{idModerator}/add/{idMember}")
	public ResponseEntity<GroupMiniDTO> addMemberSilenced(@PathVariable String idGroup, @PathVariable String idModerator, @PathVariable String idMember){
		try {
			boolean added = groupService.addMemberSilenced(idGroup, idModerator, idMember);
			if(added) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value = "silence/{idGroup}/{idModerator}/remove/{idMember}")
	public ResponseEntity<GroupMiniDTO> removeMemberSilenced(@PathVariable String idGroup, @PathVariable String idModerator, @PathVariable String idMember){
		try {
			boolean added = groupService.removeMemberSilenced(idGroup, idModerator, idMember);
			if(added) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value = "/{idGroup}/{idUser}/name")
	public ResponseEntity<GroupMiniDTO> updateName(@RequestBody GroupDTO groupDTO, @PathVariable String idGroup, @PathVariable String idUser){
		try {
			return groupService.updateName(groupDTO, idUser, idGroup);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value = "/{idGroup}/{idUser}/description")
	public ResponseEntity<GroupMiniDTO> updateDescription(@RequestBody GroupDTO groupDTO, @PathVariable String idGroup, @PathVariable String idUser){
		try {
			return groupService.updateDescription(groupDTO, idUser, idGroup);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value = "/{idGroup}/{idUser}/image")
	public ResponseEntity<GroupMiniDTO> updateImage(@RequestBody GroupDTO groupDTO, @PathVariable String idGroup, @PathVariable String idUser){
		try {
			return groupService.updateImage(groupDTO, idUser, idGroup);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	
}
