package com.jonatas.socialnetworkapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jonatas.socialnetworkapi.entities.dto.UserDTO;
import com.jonatas.socialnetworkapi.entities.helper.LikeUser;
import com.jonatas.socialnetworkapi.entities.helper.PostUser;
import com.jonatas.socialnetworkapi.enuns.TypeObject;

@Document
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//variables
	
	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	private String imageProfile;
	
	//alterar release para data//
	private String release;
	
	//alterar para data//
	private String lastLogin;
	private String description;
	
	//remover//
	private String place;
	
	private boolean privacy = false;
	private boolean status = true;
	private boolean checked = false;
	private int quantityFollowers = 0;
	private TypeObject typeObject = TypeObject.USER;
	
	//Alterar//
	private List<LikeUser> likes = new ArrayList<>();
	
	//alterar//
	private List<PostUser> posts = new ArrayList<>();
	
	@DBRef(lazy = true)
	@JsonBackReference
	private Follower follower;
	
	@DBRef(lazy = true)
	@JsonBackReference
	private Invitation invitation;
		
	@DBRef(lazy = true)
	@JsonBackReference
	private List<EntitySave> entitySaves = new ArrayList<>();
		
	@DBRef(lazy = true)
	@JsonBackReference
	private List<Comment> comments = new ArrayList<>();
	
	@DBRef(lazy = true)
	@JsonBackReference
	private List<Group> groups = new ArrayList<>();
	
	@DBRef(lazy = true)
	@JsonBackReference
	private List<User> blocked =  new ArrayList<>();
		
	//variables
	
	public User() {
		super();
	}
	
	public User(String name, String email, String password, String description, String place) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.description = description;
		this.place = place;
	}
		
	public User(UserDTO userDTO) {
		super();
		this.name = userDTO.getName();
		this.email = userDTO.getEmail();
		this.password = userDTO.getPassword();
		this.release = userDTO.getRelease();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Follower getFollower() {
		return follower;
	}

	public void setFollower(Follower follower) {
		this.follower = follower;
	}

	public Invitation getInvitation() {
		return invitation;
	}

	public void setInvitation(Invitation invitation) {
		this.invitation = invitation;
	}

	public String getImageProfile() {
		return imageProfile;
	}

	public void setImageProfile(String imageProfile) {
		this.imageProfile = imageProfile;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isPrivacy() {
		return privacy;
	}

	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
		
	public int getQuantityFollowing() {
		return getFollower().getFollowing().size();
	}

	public int getQuantityFollowers() {
		return quantityFollowers;
	}

	public void setQuantityFollowers(int quantityFollowers) {
		this.quantityFollowers += quantityFollowers;
	}
		
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
			
	public List<Comment> getComments() {
		return comments;
	}
	
	public List<LikeUser> getLikes() {
		return likes;
	}

	public TypeObject getTypeObject() {
		return typeObject;
	}

	public List<EntitySave> getEntitySaves() {
		return entitySaves;
	}

	public List<PostUser> getPosts() {
		return posts;
	}
	
	public List<User> getBlocked() {
		return blocked;
	}
	
	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public List<Group> getGroups() {
		return groups;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
