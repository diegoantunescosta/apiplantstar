package com.jonatas.socialnetworkapi.entities.helper;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jonatas.socialnetworkapi.entities.Post;
import com.jonatas.socialnetworkapi.entities.User;

public class VoteQuest {

	@DBRef(lazy = true)
	@JsonManagedReference
	private Post post;
	@DBRef(lazy = true)
	@JsonManagedReference
	private User user;
	private int vote;
	
	public VoteQuest() {
		super();
	}
	
	public VoteQuest(Post post, User user, int vote) {
		super();
		this.post = post;
		this.user = user;
		this.vote = vote;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}
	
	

}
