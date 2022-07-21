package com.jonatas.socialnetworkapi.entities.dto;

import com.jonatas.socialnetworkapi.enuns.LevelReport;
import com.jonatas.socialnetworkapi.enuns.TypeReport;

public class ReportDTO {

	private String id;
	private LevelReport levelReport;
	private String idReported;
	private TypeReport typeReport;
	private String idAuthor;
	private String release;
	
	public ReportDTO() {
		super();
	}
	
	public ReportDTO(String id, LevelReport levelReport, String idReported, TypeReport typeReport, String idAuthor,
			String release) {
		super();
		this.id = id;
		this.levelReport = levelReport;
		this.idReported = idReported;
		this.typeReport = typeReport;
		this.idAuthor = idAuthor;
		this.release = release;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(String idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}
	
	
	
	
}
