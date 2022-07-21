package com.jonatas.socialnetworkapi.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jonatas.socialnetworkapi.enuns.Level;
import com.jonatas.socialnetworkapi.enuns.TypeObject;

@Document
public class Edition implements Serializable{
	private static final long serialVersionUID = 1L;

	//variables
	
	@Id
	private String id;
	
	//alterar release para data//
	private Date release;
	
	private Object previous;
	private Object current;
	private String attribute;
	private TypeObject typeObject = TypeObject.EDITION;
	
	//alterar Level para TypeEdition//
	private Level level;
	
	@DBRef(lazy = true)
	@JsonManagedReference
	private User user;
	
	@DBRef(lazy = true)
	@JsonManagedReference
	private Entity entity;

	
	//variables
	
	public Edition() {
		super();
	}

	public Edition(User user, Entity entity, Date release, Object previous,
			Object current, String attribute, Level level) {
		super();
		this.user = user;
		this.entity = entity;
		this.release = release;
		this.previous = previous;
		this.current = current;
		this.attribute = attribute;
		this.level = level;
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


	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public Object getPrevious() {
		return previous;
	}

	public void setPrevious(Object previous) {
		this.previous = previous;
	}

	public Object getCurrent() {
		return current;
	}

	public void setCurrent(Object current) {
		this.current = current;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getId() {
		return id;
	}
	
	public TypeObject getTypeObject() {
		return typeObject;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	
}
