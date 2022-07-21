package com.jonatas.socialnetworkapi.entities.helper;

import java.util.Objects;

import com.jonatas.socialnetworkapi.enuns.TypeObject;

public class LikeUser {
	
	private String id;
	private TypeObject typeObject;
	
	public LikeUser() {
		super();
	}

	public LikeUser(String id, TypeObject typeObject) {
		super();
		this.id = id;
		this.typeObject = typeObject;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TypeObject getTypeObject() {
		return typeObject;
	}

	public void setTypeObject(TypeObject typeObject) {
		this.typeObject = typeObject;
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
		LikeUser other = (LikeUser) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
