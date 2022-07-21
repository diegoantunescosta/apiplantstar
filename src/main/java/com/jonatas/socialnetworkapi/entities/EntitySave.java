package com.jonatas.socialnetworkapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jonatas.socialnetworkapi.enuns.Level;
import com.jonatas.socialnetworkapi.enuns.TypeObject;

//alterar o nome de EntitySave para Register//
@Document
public class EntitySave implements Serializable{
	private static final long serialVersionUID = 1L;

	//variables
	
	@Id
	private String id;
	
	//alterar Level para TypeEdition//
	private Level level;
	
	private int category;
	private boolean goal = false;
	private boolean rated = false;
	private boolean reviewed = false;
	private int evaluation;
	
	//alterar review para uma referencia de um post//
	private String review;
	
	private TypeObject typeObject = TypeObject.ENTITY_SAVE;
	
	//remover//
	private boolean spoiler;
	
	//alterar release para data//
	private String release;
	
	@DBRef(lazy = true)
	@JsonManagedReference
	private User user;
	
	@DBRef(lazy = true)
	@JsonManagedReference
	private Entity entity;
	
	//remover comments//
	@DBRef(lazy = true)
	@JsonBackReference
	private List<Comment> comments = new ArrayList<>();
	
	//remover likes//
	@DBRef(lazy = true)
	@JsonBackReference
	private List<User> likes = new ArrayList<>();
		
	//variables

	public EntitySave() {
		super();
	}

	public EntitySave(User user, Entity entity, int category, Level level, Boolean spoiler) {
		super();
		this.user = user;
		this.entity = entity;
		this.category = category;
		this.level = level;
		this.spoiler = spoiler;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
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

	public String getId() {
		return id;
	}

	public TypeObject getTypeObject() {
		return typeObject;
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

	public Boolean getSpoiler() {
		return spoiler;
	}

	public void setSpoiler(Boolean spoiler) {
		this.spoiler = spoiler;
	}
	
	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}
	
	public int getLikeQuantity() {
		return getLikes().size();
	}

	public int getCommentQuantity() {
		return getComments().size();
	}

	public List<Comment> getComments() {
		return comments;
	}

	public List<User> getLikes() {
		return likes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntitySave other = (EntitySave) obj;
		return Objects.equals(id, other.id);
	}	
	
}
