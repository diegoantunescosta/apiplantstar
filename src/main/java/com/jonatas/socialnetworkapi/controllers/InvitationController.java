package com.jonatas.socialnetworkapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonatas.socialnetworkapi.services.InvitationService;

@RestController
@RequestMapping(value = "/invitations")
public class InvitationController {
	
	@Autowired
	private InvitationService invitationService;
	
	//get
	
	@GetMapping(value = "get/invitations")
	public ResponseEntity<Object> findAllMini(){
		return invitationService.findAllMini();
	}
	
	@GetMapping(value = "get/invitation/{value}")
	public ResponseEntity<Object> findByValueMini(@PathVariable String value){
		return invitationService.findByValueMini(value);
	}
	
	@GetMapping(value = "get/check/invitation/{invitationValue}")
	public ResponseEntity<Boolean> checkInvitation(@PathVariable String invitationValue){
		return invitationService.checkInvitation(invitationValue);
	}
	
	
	


}
