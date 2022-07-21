package com.jonatas.socialnetworkapi.entities.dto;

import com.jonatas.socialnetworkapi.enuns.TypeEntity;

public class EntityDTO {

	private String name;
	private String description;
	private TypeEntity typeEntity;
	
	public EntityDTO() {
		super();
	}

	public EntityDTO(String name, String description, TypeEntity typeEntity) {
		super();
		this.name = name;
		this.description = description;
		this.typeEntity = typeEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeEntity getTypeEntity() {
		return typeEntity;
	}

	public void setTypeEntity(TypeEntity typeEntity) {
		this.typeEntity = typeEntity;
	}

}
