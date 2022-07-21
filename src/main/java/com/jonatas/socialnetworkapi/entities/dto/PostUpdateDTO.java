package com.jonatas.socialnetworkapi.entities.dto;

import com.jonatas.socialnetworkapi.enuns.Level;
import com.jonatas.socialnetworkapi.enuns.TypePost;
import com.jonatas.socialnetworkapi.enuns.TypePostVisibility;

public class PostUpdateDTO{

	private String idPost;
	private String release;
	private String body;
	private int category;
	private String idAuthor;
	private String idEntity;
	private String idSeason;
	private String idEpisode;
	private TypePost typePost;
	private Level level;
	private TypePostVisibility typePostVisibility = TypePostVisibility.USER;
	private int evaluation = 0;
	private Boolean spoiler;
		
	public PostUpdateDTO() {
		super();
	}

	public PostUpdateDTO(String idPost, TypePost typePost, Level level,
			TypePostVisibility typePostVisibility, String release, String body, int category, String idAuthor,
			String idEntity, String idSeason, String idEpisode, int evaluation, Boolean spoiler) {
		super();
		this.idPost = idPost;
		this.typePost = typePost;
		this.level = level;
		this.typePostVisibility = typePostVisibility;
		this.release = release;
		this.body = body;
		this.category = category;
		this.idAuthor = idAuthor;
		this.idEntity = idEntity;
		this.idSeason = idSeason;
		this.idEpisode = idEpisode;
		this.evaluation = evaluation;
		this.setSpoiler(spoiler);
	}

	public String getIdPost() {
		return idPost;
	}

	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}

	public TypePost getTypePost() {
		return typePost;
	}

	public void setTypePost(TypePost typePost) {
		this.typePost = typePost;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(String idAuthor) {
		this.idAuthor = idAuthor;
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

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public TypePostVisibility getTypePostVisibility() {
		return typePostVisibility;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public Boolean getSpoiler() {
		return spoiler;
	}

	public void setSpoiler(Boolean spoiler) {
		this.spoiler = spoiler;
	}
}
