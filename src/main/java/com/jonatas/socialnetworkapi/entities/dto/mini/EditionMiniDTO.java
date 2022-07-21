package com.jonatas.socialnetworkapi.entities.dto.mini;

import java.util.Date;

import com.jonatas.socialnetworkapi.entities.Edition;
import com.jonatas.socialnetworkapi.enuns.Level;
import com.jonatas.socialnetworkapi.enuns.TypeObject;

public class EditionMiniDTO {

	private String id;
	private UserMiniDTO user;
	private EntityMiniDTO entity;
	private String attribute;
	private Object previous;
	private Object current;
	private Date release;
	private TypeObject typeObject = TypeObject.EDITION;
	private Level level;
	
	public EditionMiniDTO() {
		super();
	}
	
	public EditionMiniDTO(Edition edition) {
		super();
		this.id = edition.getId();
		this.user = edition.getUser() != null ? new UserMiniDTO(edition.getUser()) : null;
		this.entity = edition.getEntity() != null ? new EntityMiniDTO(edition.getEntity()): null;
		this.release = edition.getRelease();
		this.previous = edition.getPrevious();
		this.current = edition.getCurrent();
		this.attribute = edition.getAttribute();
		this.level = edition.getLevel();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserMiniDTO getUser() {
		return user;
	}

	public void setUser(UserMiniDTO user) {
		this.user = user;
	}

	public EntityMiniDTO getEntity() {
		return entity;
	}

	public void setEntity(EntityMiniDTO entity) {
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
}
