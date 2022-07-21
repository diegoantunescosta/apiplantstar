package com.jonatas.socialnetworkapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonatas.socialnetworkapi.entities.dto.ReportDTO;
import com.jonatas.socialnetworkapi.services.ReportService;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	//get
	
	@GetMapping(value = "/get/all")
	public ResponseEntity<Object> findAll(){
		return reportService.findAll();
	}
	
	@GetMapping(value = "/get/all/news")
	public ResponseEntity<Object> findNews(){
		return reportService.findNews();
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Object> findById(@PathVariable String id){
		return reportService.findById(id);
	}
	
	//post
	@PostMapping(value = "/post")
	public ResponseEntity<Object> findById(@RequestBody ReportDTO reportDTO){
		return reportService.newReport(reportDTO);
	}
	
	//put
	@PutMapping(value = "/put/checked/{id}")
	public ResponseEntity<Object> updateChecked(@PathVariable String id){
		return reportService.updateChecked(id);
	}
}
