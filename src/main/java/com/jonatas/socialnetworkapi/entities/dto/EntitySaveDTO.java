package com.jonatas.socialnetworkapi.entities.dto;

import com.jonatas.socialnetworkapi.enuns.Level;

public class EntitySaveDTO {

	private String idEntitySave;
	private String idUser;
	private String idEntity;
	private String idSeason;
	private String idEpisode;
	private int category;
	private boolean goal;
	private boolean rated;
	private boolean reviewed;
	private int evaluation;
	private String review;
	private Level level;
	private boolean spoiler = false;
	private String release;
	
	public EntitySaveDTO() {
		super();
	}
	
	public EntitySaveDTO(String idEntitySave, String idUser, String idEntity, String idSeason, String idEpisode,
			int category, boolean goal, boolean rated, boolean reviewed, int evaluation, String review,
			Level level, boolean spoiler) {
		super();
		this.idEntitySave = idEntitySave;
		this.idUser = idUser;
		this.idEntity = idEntity;
		this.idSeason = idSeason;
		this.idEpisode = idEpisode;
		this.category = category;
		this.goal = goal;
		this.rated = rated;
		this.reviewed = reviewed;
		this.evaluation = evaluation;
		this.review = review;
		this.level = level;
		this.spoiler = spoiler;
	}

	public String getIdEntitySave() {
		return idEntitySave;
	}

	public void setIdEntitySave(String idEntitySave) {
		this.idEntitySave = idEntitySave;
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

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public boolean isGoal() {
		return goal;
	}

	public void setGoal(boolean goal) {
		this.goal = goal;
	}

	public boolean isRated() {
		return rated;
	}

	public void setRated(boolean rated) {
		this.rated = rated;
	}

	public boolean isReviewed() {
		return reviewed;
	}

	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public boolean isSpoiler() {
		return spoiler;
	}

	public void setSpoiler(boolean spoiler) {
		this.spoiler = spoiler;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	
	
}
