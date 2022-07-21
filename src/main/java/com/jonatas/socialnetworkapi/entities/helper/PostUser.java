package com.jonatas.socialnetworkapi.entities.helper;

import java.util.Objects;

import com.jonatas.socialnetworkapi.enuns.TypePost;

public class PostUser {

	private String id;
	private TypePost typePost;

	public PostUser() {
		super();
	}

	public PostUser(String id, TypePost typePost) {
		super();
		this.id = id;
		this.typePost = typePost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TypePost getTypePost() {
		return typePost;
	}

	public void setTypePost(TypePost typePost) {
		this.typePost = typePost;
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
		PostUser other = (PostUser) obj;
		return Objects.equals(id, other.id);
	}

	
}
