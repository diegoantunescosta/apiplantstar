package com.jonatas.socialnetworkapi.entities.dto;

public class PostTalkDTO {
	
	private String idPost;
	private String release;
	private String body;
	private Boolean spoiler;
	private String idAuthor;
	private String title;
		
	public PostTalkDTO() {
		super();
	}

	public PostTalkDTO(String idPost, String release, String body,
			Boolean spoiler, String idAuthor, String title) {
		super();
		this.idPost = idPost;
		this.release = release;
		this.body = body;
		this.spoiler = spoiler;
		this.idAuthor = idAuthor;
		this.title = title;
	}

	public String getIdPost() {
		return idPost;
	}

	public void setIdPost(String idPost) {
		this.idPost = idPost;
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

	public Boolean getSpoiler() {
		return spoiler;
	}

	public void setSpoiler(Boolean spoiler) {
		this.spoiler = spoiler;
	}

	public String getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(String idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
}
