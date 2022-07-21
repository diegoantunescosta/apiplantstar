package com.jonatas.socialnetworkapi.entities.dto.mini;

import com.jonatas.socialnetworkapi.entities.post.Talk;
import com.jonatas.socialnetworkapi.enuns.TypeObject;
import com.jonatas.socialnetworkapi.enuns.TypePost;
import com.jonatas.socialnetworkapi.enuns.TypePostVisibility;

public class PostTalkMiniDTO {

	private String id;
	private String release;
	private String body;
	private TypePost typePost;
	private TypePostVisibility typePostVisibility;
	private int likeQuantity = 0;
	private int commentQuantity = 0;
	private TypeObject typeObject = TypeObject.POST;
	private Boolean spoiler;
	private UserMiniDTO author;
	private Boolean Liked;
	private UserMiniDTO like;
	private String title;
	
	public PostTalkMiniDTO() {
		super();
	}

	public PostTalkMiniDTO(String id, String release, String body, TypePost typePost,
			TypePostVisibility typePostVisibility, int likeQuantity, int commentQuantity, TypeObject typeObject,
			Boolean spoiler, UserMiniDTO author, String title) {
		super();
		this.id = id;
		this.release = release;
		this.body = body;
		this.typePost = typePost;
		this.typePostVisibility = typePostVisibility;
		this.likeQuantity = likeQuantity;
		this.commentQuantity = commentQuantity;
		this.typeObject = typeObject;
		this.spoiler = spoiler;
		this.author = author;
		this.title = title;
	}
	
	

	public PostTalkMiniDTO(Talk post) {
		super();
		this.id = post.getId();
		this.release = post.getRelease();
		this.body = post.getBody();
		this.typePost = post.getTypePost();
		this.typePostVisibility = post.getTypePostVisibility();
		this.likeQuantity = post.getLikeQuantity();
		this.commentQuantity = post.getCommentQuantity();
		this.typeObject = post.getTypeObject();
		this.spoiler = post.getSpoiler();
		this.author = post.getAuthor() != null ? new UserMiniDTO(post.getAuthor()) : null;
		this.title = post.getTitle();
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

	public TypePost getTypePost() {
		return typePost;
	}

	public void setTypePost(TypePost typePost) {
		this.typePost = typePost;
	}

	public TypePostVisibility getTypePostVisibility() {
		return typePostVisibility;
	}

	public void setTypePostVisibility(TypePostVisibility typePostVisibility) {
		this.typePostVisibility = typePostVisibility;
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

	public Boolean getSpoiler() {
		return spoiler;
	}

	public void setSpoiler(Boolean spoiler) {
		this.spoiler = spoiler;
	}

	public UserMiniDTO getAuthor() {
		return author;
	}

	public void setAuthor(UserMiniDTO author) {
		this.author = author;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
}
