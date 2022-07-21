package com.jonatas.socialnetworkapi.entities.dto.mini;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jonatas.socialnetworkapi.entities.Follower;
import com.jonatas.socialnetworkapi.entities.User;
import com.jonatas.socialnetworkapi.enuns.TypeObject;

public class FollowerMiniDTO {

	private String id;
	private Date release;
	private UserMiniDTO user;
	private TypeObject typeObject = TypeObject.FOLLOWER;
	private List<UserMiniDTO> following = new ArrayList<>();
	
	public FollowerMiniDTO() {
		super();
	}

	public FollowerMiniDTO(Follower follower) {
		super();
		this.id = follower.getId();
		this.release = follower.getRelease();
		this.user = follower.getUser() != null ? new UserMiniDTO(follower.getUser()) : null;
		setFollowing(follower.getFollowing());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public UserMiniDTO getUser() {
		return user;
	}

	public void setUser(UserMiniDTO user) {
		this.user = user;
	}

	public List<UserMiniDTO> getFollowing() {
		return following;
	}

	public void setFollowing(List<User> following) {
		for(User user : following) {
			if(user != null) {
				UserMiniDTO userMiniDTO = new UserMiniDTO(user);
				this.following.add(userMiniDTO);
			}
		}
	}

	public TypeObject getTypeObject() {
		return typeObject;
	}

	public void setTypeObject(TypeObject typeObject) {
		this.typeObject = typeObject;
	}	
}
