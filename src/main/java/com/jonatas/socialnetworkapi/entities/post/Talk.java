package com.jonatas.socialnetworkapi.entities.post;

import com.jonatas.socialnetworkapi.entities.Post;
import com.jonatas.socialnetworkapi.entities.User;
import com.jonatas.socialnetworkapi.enuns.TypePost;
import com.jonatas.socialnetworkapi.enuns.TypePostVisibility;

public class Talk extends Post {
	private static final long serialVersionUID = 1L;
	
	private String title;

	public Talk() {
		super();
	}
	
	public Talk(String release, String body, TypePost typePost, TypePostVisibility typePostVisibility, User author,
			Boolean spoiler) {
		super(release, body, typePost, typePostVisibility, author, spoiler);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
