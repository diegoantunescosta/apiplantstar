package com.jonatas.socialnetworkapi.entities.dto.mini;

import com.jonatas.socialnetworkapi.entities.Entity;
import com.jonatas.socialnetworkapi.enuns.TypeEntity;
import com.jonatas.socialnetworkapi.enuns.TypeObject;

public class EntityMiniDTO {
	
	private String id;
	private String name;
	private String description;
	private int evaluationQuantity = 0;
	private double evaluationAverage = 0.0;
	private int seasonQuantity = 0;
	private TypeObject typeObject = TypeObject.ENTITY;
	private TypeEntity typeEntity;
	private String image;
	private int category1 = 0;
	private int category2 = 0;
	private int category3 = 0;
	private int category4 = 0;
	
	public EntityMiniDTO() {
		super();
	}
	
	public EntityMiniDTO(Entity entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.evaluationQuantity = entity.getEvaluationQuantity();
		this.evaluationAverage = entity.getEvaluationAverage();
		this.typeObject = entity.getTypeObject();
		this.typeEntity = entity.getTypeEntity();
		this.image = entity.getImage();
		this.category1 = entity.getCategory1();
		this.category2 = entity.getCategory2();
		this.category3 = entity.getCategory3();
		this.category4 = entity.getCategory4();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public int getEvaluationQuantity() {
		return evaluationQuantity;
	}

	public void setEvaluationQuantity(int evaluationQuantity) {
		this.evaluationQuantity = evaluationQuantity;
	}

	public double getEvaluationAverage() {
		return evaluationAverage;
	}

	public void setEvaluationAverage(double evaluationAverage) {
		this.evaluationAverage = evaluationAverage;
	}

	public int getSeasonQuantity() {
		return seasonQuantity;
	}

	public void setSeasonQuantity(int seasonQuantity) {
		this.seasonQuantity = seasonQuantity;
	}

	public TypeObject getTypeObject() {
		return typeObject;
	}

	public void setTypeObject(TypeObject typeObject) {
		this.typeObject = typeObject;
	}

	public TypeEntity getTypeEntity() {
		return typeEntity;
	}

	public void setTypeEntity(TypeEntity typeEntity) {
		this.typeEntity = typeEntity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getCategory1() {
		return category1;
	}

	public void setCategory1(int category1) {
		this.category1 = category1;
	}

	public int getCategory2() {
		return category2;
	}

	public void setCategory2(int category2) {
		this.category2 = category2;
	}

	public int getCategory3() {
		return category3;
	}

	public void setCategory3(int category3) {
		this.category3 = category3;
	}

	public int getCategory4() {
		return category4;
	}

	public void setCategory4(int category4) {
		this.category4 = category4;
	}

	
		
}
