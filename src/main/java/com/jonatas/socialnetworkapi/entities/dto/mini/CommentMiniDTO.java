package com.jonatas.socialnetworkapi.entities.dto.mini;

import com.jonatas.socialnetworkapi.entities.Comment;
import com.jonatas.socialnetworkapi.enuns.TypeComment;
import com.jonatas.socialnetworkapi.enuns.TypeObject;

public class CommentMiniDTO {

	private String id;
	private String release;
	private String body;
	private UserMiniDTO author;
	private TypeObject typeObject = TypeObject.COMMENT;
	private int likeQuantity = 0;
	private Boolean liked;
	private TypeComment typeComment;
	
	public CommentMiniDTO() {
		super();
	}
	
	public CommentMiniDTO(Comment comment) {
		super();
		this.id = comment.getId();
		this.release = comment.getRelease();
		this.body = comment.getBody();
		this.author = comment.getAuthor() != null ? new UserMiniDTO(comment.getAuthor()) : null;
		this.likeQuantity = comment.getLikeQuantity();
		this.typeComment = comment.getTypeComment();
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

	public UserMiniDTO getAuthor() {
		return author;
	}

	public void setAuthor(UserMiniDTO author) {
		this.author = author;
	}

	public TypeObject getTypeObject() {
		return typeObject;
	}

	public void setTypeObject(TypeObject typeObject) {
		this.typeObject = typeObject;
	}

	public int getLikeQuantity() {
		return likeQuantity;
	}

	public void setLikeQuantity(int likeQuantity) {
		this.likeQuantity = likeQuantity;
	}

	public Boolean getLiked() {
		return liked;
	}

	public void setLiked(Boolean liked) {
		this.liked = liked;
	}

	public TypeComment getTypeComment() {
		return typeComment;
	}

	public void setTypeComment(TypeComment typeComment) {
		this.typeComment = typeComment;
	}
	
	

}
