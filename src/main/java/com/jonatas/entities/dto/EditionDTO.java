package com.jonatas.socialnetworkapi.entities.dto;

import java.util.Date;

import com.jonatas.socialnetworkapi.enuns.Level;

public class EditionDTO {

	private String idUser;
	private String idEntity;
	private String idSeason;
	private String idEpisode;
	private Date release;
	private Object previous;
	private Object current;
	private String attribute;
	private Level level;
	
	public EditionDTO() {
		super();
	}

	public EditionDTO(String user, String entity, String season, String episode, Date release, Object previous,
			Object current, String attribute, Level level) {
		super();
		this.idUser = user;
		this.idEntity = entity;
		this.idSeason = season;
		this.idEpisode = episode;
		this.release = release;
		this.previous = previous;
		this.current = current;
		this.attribute = attribute;
		this.level = level;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getIdEntity() {
		return idEntity;
	}

	public void setIdEntity(String idEntity) {
		this.idEntity = idEntity;
	}

	public String getIdSeason() {
		return idSeason;
	}

	public void setIdSeason(String idSeason) {
		this.idSeason = idSeason;
	}

	public String getIdEpisode() {
		return idEpisode;
	}

	public void setIdEpisode(String idEpisode) {
		this.idEpisode = idEpisode;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public Object getPrevious() {
		return previous;
	}

	public void setPrevious(Object previous) {
		this.previous = previous;
	}

	public Object getCurrent() {
		return current;
	}

	public void setCurrent(Object current) {
		this.current = current;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}


	
}
