package com.jonatas.socialnetworkapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jonatas.socialnetworkapi.entities.Edition;
import com.jonatas.socialnetworkapi.entities.dto.mini.EditionMiniDTO;
import com.jonatas.socialnetworkapi.repositories.EditionRepository;

@Service
public class EditionService {

	//repositories
	
	@Autowired
	private EditionRepository editionRepository;
	
	//methods
	
	//get
	
	public ResponseEntity<Object> findAllMini(){
		try {
			List<Edition> editions = editionRepository.findAll();
			List<EditionMiniDTO> editionMiniDTOs = new ArrayList<>();
			for(Edition edition : editions) {
				EditionMiniDTO editionMiniDTO = new EditionMiniDTO(edition);
				editionMiniDTOs.add(editionMiniDTO);
			}
			return ResponseEntity.ok().body(editionMiniDTOs);
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Object> findByIdMini(String id){
		try {
			Edition edition = editionRepository.findById(id).get();
			EditionMiniDTO editionMiniDTO = new EditionMiniDTO(edition);
			return ResponseEntity.ok().body(editionMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	//post
	
	public ResponseEntity<Object> newEdition(Edition edition){
		try {
			edition = editionRepository.insert(edition);
			EditionMiniDTO editionMiniDTO = new EditionMiniDTO(edition);
			return ResponseEntity.ok().body(editionMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	//internal
	
	public ResponseEntity<Object> findById(String id){
		try {
			Edition edition = editionRepository.findById(id).get();
			return ResponseEntity.ok().body(edition);
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
