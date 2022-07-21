package com.jonatas.socialnetworkapi.entities.post;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jonatas.socialnetworkapi.entities.Group;
import com.jonatas.socialnetworkapi.entities.Post;
import com.jonatas.socialnetworkapi.entities.User;
import com.jonatas.socialnetworkapi.enuns.TypePost;
import com.jonatas.socialnetworkapi.enuns.TypePostVisibility;

public class TalkGroup extends Post {
	private static final long serialVersionUID = 1L;
	
	private boolean close;
	private User closedBy;
	private String title;
	
	@DBRef(lazy = true)
	@JsonManagedReference
	private Group group;

	public TalkGroup() {
		super();
	}
	
	public TalkGroup(String release, String body, TypePost typePost, TypePostVisibility typePostVisibility, User author,
			Boolean spoiler, boolean close, User closedBy, Group group) {
		super(release, body, typePost, typePostVisibility, author, spoiler);
		this.close = close;
		this.closedBy = closedBy;
		this.group = group;
	}

	public boolean isClose() {
		return close;
	}

	public void setClose(boolean close) {
		this.close = close;
	}

	public User getClosedBy() {
		return closedBy;
	}

	public void setClosedBy(User closedBy) {
		this.closedBy = closedBy;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
