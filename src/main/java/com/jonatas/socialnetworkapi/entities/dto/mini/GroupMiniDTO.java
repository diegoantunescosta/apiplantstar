package com.jonatas.socialnetworkapi.entities.dto.mini;

import com.jonatas.socialnetworkapi.entities.Group;
import com.jonatas.socialnetworkapi.entities.User;
import com.jonatas.socialnetworkapi.enuns.TypeObject;

public class GroupMiniDTO {

	private String id;
	private String name;
	private String description;
	private UserMiniDTO creator;
	private String creationDate;
	private String image;
	
	private int quantityMembers;
	private int quantityModerators;
	private int quantitySilenced;
	private int quantityPosts;
	
	private boolean userIsMember;
	private boolean userIsModerator;
	private boolean userIsSilenced;
	
	private TypeObject typeObject = TypeObject.GROUP;
	
	public GroupMiniDTO(Group group, User user) {
		super();
		this.id = group.getId();
		this.name = group.getName();
		this.description = group.getDescription();
		this.creator = group.getCreator() != null ? new UserMiniDTO(group.getCreator()) : null;
		this.creationDate = group.getCreationDate();
		this.image = group.getImage();
		this.quantityMembers = group.getMembers().size() + 1;
		this.quantityModerators = group.getModerators().size();
		this.quantitySilenced = group.getMembersSilenced().size();
		this.quantityPosts = group.getPosts().size();
		
		if(group.getMembers().contains(user) || group.getCreator().equals(user)) {
			setUserIsMember(true);
		}else {
			setUserIsMember(false);
		}
		if(group.getModerators().contains(user) || group.getCreator().equals(user)) {
			setUserIsModerator(true);
		}else {
			setUserIsModerator(false);
		}
		if(group.getMembersSilenced().contains(user)) {
			setUserIsSilenced(true);
		}else {
			setUserIsSilenced(false);
		}
	}
	
	public GroupMiniDTO(Group group) {
		super();
		this.id = group.getId();
		this.name = group.getName();
		this.description = group.getDescription();
		this.creator = group.getCreator() != null ? new UserMiniDTO(group.getCreator()) : null;
		this.creationDate = group.getCreationDate();
		this.image = group.getImage();
		this.quantityMembers = group.getMembers().size() + 1;
		this.quantityModerators = group.getModerators().size();
		this.quantitySilenced = group.getMembersSilenced().size();
		this.quantityPosts = group.getPosts().size();
	
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

	public UserMiniDTO getCreator() {
		return creator;
	}

	public void setCreator(UserMiniDTO creator) {
		this.creator = creator;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantityMembers() {
		return quantityMembers;
	}

	public void setQuantityMembers(int quantityMembers) {
		this.quantityMembers = quantityMembers;
	}

	public int getQuantityModerators() {
		return quantityModerators;
	}

	public void setQuantityModerators(int quantityModerators) {
		this.quantityModerators = quantityModerators;
	}

	public int getQuantitySilenced() {
		return quantitySilenced;
	}

	public void setQuantitySilenced(int quantitySilenced) {
		this.quantitySilenced = quantitySilenced;
	}

	public int getQuantityPosts() {
		return quantityPosts;
	}

	public void setQuantityPosts(int quantityPosts) {
		this.quantityPosts = quantityPosts;
	}

	public boolean isUserIsMember() {
		return userIsMember;
	}

	public void setUserIsMember(boolean userIsMember) {
		this.userIsMember = userIsMember;
	}

	public boolean isUserIsModerator() {
		return userIsModerator;
	}

	public void setUserIsModerator(boolean userIsModerator) {
		this.userIsModerator = userIsModerator;
	}

	public boolean isUserIsSilenced() {
		return userIsSilenced;
	}

	public void setUserIsSilenced(boolean userIsSilenced) {
		this.userIsSilenced = userIsSilenced;
	}

	public TypeObject getTypeObject() {
		return typeObject;
	}

	public void setTypeObject(TypeObject typeObject) {
		this.typeObject = typeObject;
	}
	
	
}
