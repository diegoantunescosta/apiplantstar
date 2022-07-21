package com.jonatas.socialnetworkapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jonatas.socialnetworkapi.enuns.TypeObject;

@Document
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//variables
	
	@Id
	private String id;
	private String name;
	private String description;
	private User creator;
	private String creationDate;
	private String image;
	private TypeObject typeObject = TypeObject.GROUP;	
	
	//References
	
	//alterar para um objeto do tipo UsersGroup//
	@JsonBackReference
	@DocumentReference(lazy = true, collection = "user")
	private List<User> members = new ArrayList<>();
	
	//alterar para um objeto do tipo UsersGroup//
	@JsonBackReference
	@DocumentReference(lazy = true, collection = "user")
	private List<User> moderators = new ArrayList<>();
	
	//alterar para um objeto do tipo UsersGroup//
	@JsonBackReference
	@DocumentReference(lazy = true, collection = "user")
	private List<User> membersSilenced = new ArrayList<>();
	
	//alterar para um objeto do tipo PostsGroup//
	@JsonBackReference
	@DocumentReference(lazy = true, collection = "post")
	private List<Post> posts = new ArrayList<>();
	
	//References
	
	//variables
	
	public Group() {
		super();
	}
	
	public Group(String name, String description, User creator, String creationDate) {
		super();
		this.name = name;
		this.description = description;
		this.creator = creator;
		this.creationDate = creationDate;
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

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getQuantityMembers() {
		return getMembers().size();
	}

	public int getQuantityModerators() {
		return getModerators().size();
	}

	public int getQuantitySilenced() {
		return getMembersSilenced().size();
	}


	public int getQuantityPosts() {
		return getPosts().size();
	}

	public void setQuantityPosts(int quantityPosts) {
		quantityPosts = this.posts.size();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public List<User> getMembers() {
		return members;
	}

	public List<User> getModerators() {
		return moderators;
	}

	public List<User> getMembersSilenced() {
		return membersSilenced;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public TypeObject getTypeObject() {
		return typeObject;
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
		Group other = (Group) obj;
		return Objects.equals(id, other.id);
	}

}
