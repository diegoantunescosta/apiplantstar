package com.jonatas.socialnetworkapi.entities.dto.mini;

import com.jonatas.socialnetworkapi.entities.Report;
import com.jonatas.socialnetworkapi.enuns.LevelReport;
import com.jonatas.socialnetworkapi.enuns.TypeObject;
import com.jonatas.socialnetworkapi.enuns.TypeReport;

public class ReportMiniDTO {

	private String id;
	private TypeObject typeObject = TypeObject.REPORT;
	private LevelReport levelReport;
	private String idReported;
	private TypeReport typeReport;
	private UserMiniDTO author;
	private Boolean checked = false;
	private String release;
	
	public ReportMiniDTO() {
		super();
	}

	public ReportMiniDTO(String id, TypeObject typeObject, LevelReport levelReport, String idReported,
			TypeReport typeReport, UserMiniDTO author, Boolean checked, String release) {
		super();
		this.id = id;
		this.typeObject = typeObject;
		this.levelReport = levelReport;
		this.idReported = idReported;
		this.typeReport = typeReport;
		this.author = author;
		this.checked = checked;
		this.release = release;
	}
	
	public ReportMiniDTO(Report report) {
		super();
		this.id = report.getId();
		this.typeObject = report.getTypeObject();
		this.levelReport = report.getLevelReport();
		this.idReported = report.getIdReported();
		this.typeReport = report.getTypeReport();
		this.author = report.getAuthor() != null ? new UserMiniDTO(report.getAuthor()) : null;
		this.checked = report.getChecked();
		this.release = report.getRelease();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TypeObject getTypeObject() {
		return typeObject;
	}

	public void setTypeObject(TypeObject typeObject) {
		this.typeObject = typeObject;
	}

	public LevelReport getLevelReport() {
		return levelReport;
	}

	public void setLevelReport(LevelReport levelReport) {
		this.levelReport = levelReport;
	}

	public String getIdReported() {
		return idReported;
	}

	public void setIdReported(String idReported) {
		this.idReported = idReported;
	}

	public TypeReport getTypeReport() {
		return typeReport;
	}

	public void setTypeReport(TypeReport typeReport) {
		this.typeReport = typeReport;
	}
	
	public UserMiniDTO getAuthor() {
		return author;
	}

	public void setAuthor(UserMiniDTO author) {
		this.author = author;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}
	
	
}
