package com.jonatas.socialnetworkapi.entities.dto.mini;

import java.util.ArrayList;
import java.util.List;

import com.jonatas.socialnetworkapi.entities.EntitySave;
import com.jonatas.socialnetworkapi.enuns.Level;
import com.jonatas.socialnetworkapi.enuns.TypeObject;

public class EntitySaveMiniDTO {

	private String id;
	private Level level;
	private int category;
	private boolean goal;
	private boolean rated;
	private boolean reviewed;
	private UserMiniDTO user;
	private EntityMiniDTO entity;
	private int evaluation;
	private String review;
	private TypeObject typeObject = TypeObject.ENTITY_SAVE;
	List<String> historic = new ArrayList<>();
	private boolean spoiler = false;
	private String release;
	private int likeQuantity = 0;
	private int commentQuantity = 0;
	private Boolean Liked;
	private UserMiniDTO like;
	
	public EntitySaveMiniDTO() {
		super();
	}
	
	public EntitySaveMiniDTO(EntitySave entitySave) {
		super();
		this.id = entitySave.getId();
		this.level = entitySave.getLevel();
		this.category = entitySave.getCategory();
		this.goal = entitySave.isGoal();
		this.rated = entitySave.isRated();
		this.reviewed = entitySave.isReviewed();
		this.user = entitySave.getUser()!= null ? new UserMiniDTO(entitySave.getUser()) : null;
		this.entity = entitySave.getEntity() != null? new EntityMiniDTO(entitySave.getEntity()) : null;
		this.evaluation = entitySave.getEvaluation();
		this.review = entitySave.getReview();
		this.spoiler = entitySave.getSpoiler();
		this.release = entitySave.getRelease();
		this.likeQuantity = entitySave.getLikeQuantity();
		this.commentQuantity = entitySave.getCommentQuantity();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
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

	public UserMiniDTO getUser() {
		return user;
	}

	public void setUser(UserMiniDTO user) {
		this.user = user;
	}

	public EntityMiniDTO getEntity() {
		return entity;
	}

	public void setEntity(EntityMiniDTO entity) {
		this.entity = entity;
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

	public TypeObject getTypeObject() {
		return typeObject;
	}

	public void setTypeObject(TypeObject typeObject) {
		this.typeObject = typeObject;
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

	public int getLikeQuantity() {
		return likeQuantity;
	}

	public void setLikeQuantity(int likeQuantity) {
		this.likeQuantity = likeQuantity;
	}

	public int getCommentQuantity() {
		return commentQuantity;
	}

	public void setCommentQuantity(int commentQuantity) {
		this.commentQuantity = commentQuantity;
	}

	public Boolean getLiked() {
		return Liked;
	}

	public void setLiked(Boolean liked) {
		Liked = liked;
	}

	public UserMiniDTO getLike() {
		return like;
	}

	public void setLike(UserMiniDTO like) {
		this.like = like;
	}
		
}
