package com.jonatas.socialnetworkapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jonatas.socialnetworkapi.entities.Report;
import com.jonatas.socialnetworkapi.entities.User;
import com.jonatas.socialnetworkapi.entities.dto.ReportDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.ReportMiniDTO;
import com.jonatas.socialnetworkapi.repositories.ReportRepository;

@Service
public class ReportService {

	@Autowired
	private ReportRepository reportRepository;
	
	@Autowired
	@Lazy
	private UserService userService;
	
	//get
	
	public ResponseEntity<Object> findAll(){
		try {
			List<Report> reports = reportRepository.findAll();
			List<ReportMiniDTO> reportMiniDTOs = new ArrayList<>();
			for(Report report : reports) {
				ReportMiniDTO reportMiniDTO = new ReportMiniDTO(report);
				reportMiniDTOs.add(reportMiniDTO);
			}
			return ResponseEntity.ok().body(reportMiniDTOs);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	public ResponseEntity<Object> findNews(){
		try {
			List<Report> reports = reportRepository.findAll();
			List<ReportMiniDTO> reportMiniDTOs = new ArrayList<>();
			for(Report report : reports) {
				if(!report.getChecked()) {
					ReportMiniDTO reportMiniDTO = new ReportMiniDTO(report);
					reportMiniDTOs.add(reportMiniDTO);
				}
			}
			return ResponseEntity.ok().body(reportMiniDTOs);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	public ResponseEntity<Object> findById(String id){
		try {
			Report report = reportRepository.findById(id).get();
			ReportMiniDTO reportMiniDTO = new ReportMiniDTO(report);
			return ResponseEntity.ok().body(reportMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	//post
	public ResponseEntity<Object> newReport(ReportDTO reportDTO){
		try {
			User author = (User) userService.findById(reportDTO.getIdAuthor()).getBody();
			Report report = new Report(reportDTO.getLevelReport(), reportDTO.getIdReported(), reportDTO.getTypeReport(), author, reportDTO.getRelease());
			reportRepository.save(report);
			return ResponseEntity.created(null).build();
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	//put
	
	public ResponseEntity<Object> updateChecked(String id){
		try {
			Report report = reportRepository.findById(id).get();
			report.setChecked(true);
			reportRepository.save(report);
			ReportMiniDTO reportMiniDTO = new ReportMiniDTO(report);
			return ResponseEntity.accepted().body(reportMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	
}
