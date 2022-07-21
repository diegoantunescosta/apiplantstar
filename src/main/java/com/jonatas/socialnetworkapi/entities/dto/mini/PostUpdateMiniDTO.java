package com.jonatas.socialnetworkapi.entities.dto.mini;

import com.jonatas.socialnetworkapi.entities.post.Update;
import com.jonatas.socialnetworkapi.enuns.Level;
import com.jonatas.socialnetworkapi.enuns.TypeObject;
import com.jonatas.socialnetworkapi.enuns.TypePost;
import com.jonatas.socialnetworkapi.enuns.TypePostVisibility;

public class PostUpdateMiniDTO {

	private String id;
	private String release;
	private String body;
	private int category;
	private UserMiniDTO author;
	private EntityMiniDTO entity;
	private int likeQuantity = 0;
	private int commentQuantity = 0;
	private TypeObject typeObject = TypeObject.POST;
	private TypePostVisibility typePostVisibility = TypePostVisibility.USER;
	private Level level;
	private TypePost typePost;
	private boolean spoiler;
	private int evaluation;
	private Boolean Liked;
	private UserMiniDTO like;
	
	public PostUpdateMiniDTO() {
		super();
	}
	
	public PostUpdateMiniDTO(Update post) {
		super();
		this.id = post.getId();
		this.release = post.getRelease();
		this.body = post.getBody();
		this.category = post.getCategory();
		this.author = post.getAuthor() != null ? new UserMiniDTO(post.getAuthor()) : null;
		this.entity = post.getEntity() != null ? new EntityMiniDTO(post.getEntity()) : null;
		this.likeQuantity = post.getLikeQuantity();
		this.commentQuantity = post.getCommentQuantity();
		this.level = post.getLevel();
		this.spoiler = post.getSpoiler();
		this.typePost = post.getTypePost();
		this.evaluation = post.getEvaluation();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public UserMiniDTO getAuthor() {
		return author;
	}

	public void setAuthor(UserMiniDTO author) {
		this.author = author;
	}

	public EntityMiniDTO getEntity() {
		return entity;
	}

	public void setEntity(EntityMiniDTO entity) {
		this.entity = entity;
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

	public TypeObject getTypeObject() {
		return typeObject;
	}

	public void setTypeObject(TypeObject typeObject) {
		this.typeObject = typeObject;
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

	public TypePost getTypePost() {
		return typePost;
	}

	public void setTypePost(TypePost typePost) {
		this.typePost = typePost;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
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

	public TypePostVisibility getTypePostVisibility() {
		return typePostVisibility;
	}

	public void setTypePostVisibility(TypePostVisibility typePostVisibility) {
		this.typePostVisibility = typePostVisibility;
	}

	
	
	
}
