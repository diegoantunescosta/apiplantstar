package com.jonatas.socialnetworkapi.entities.dto;

import com.jonatas.socialnetworkapi.enuns.TypeComment;

public class CommentDTO {

	private String idComment;
	private String release;
	private String body;
	private String idAuthor;
	private String idPost;
	private String idEntitySave;
	private TypeComment typeComment;
		
	public CommentDTO() {
		super();
	}

	public CommentDTO(String release, String body, String idAuthor, String post) {
		super();
		this.release = release;
		this.body = body;
		this.idAuthor = idAuthor;
		this.idPost = post;
	}

	public String getIdComment() {
		return idComment;
	}

	public void setIdComment(String idComment) {
		this.idComment = idComment;
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

	public String getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(String idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getIdPost() {
		return idPost;
	}

	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}

	public String getIdEntitySave() {
		return idEntitySave;
	}

	public void setIdEntitySave(String idEntitySave) {
		this.idEntitySave = idEntitySave;
	}

	public TypeComment getTypeComment() {
		return typeComment;
	}

	public void setTypeComment(TypeComment typeComment) {
		this.typeComment = typeComment;
	}
	
	

	
}
