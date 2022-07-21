package com.jonatas.socialnetworkapi.entities.dto;

public class UserDTO {

	private String idUser;
	private String name;
	private String email;
	private String password;
	private String imageProfile;
	private String release;
	private String description;
	private String place;
	private boolean privacy = false;
	private boolean status = true;
	private boolean checked = false;
	
	private String invitation;
	
	public UserDTO() {
		super();
	}

	public UserDTO(String id, String name, String email, String password, String imageProfile, String description,
			String place, boolean privacy, boolean status, boolean checked, String release) {
		super();
		this.idUser = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.imageProfile = imageProfile;
		this.release = release;
		this.description = description;
		this.place = place;
		this.privacy = privacy;
		this.status = status;
		this.checked = checked;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public boolean isPrivacy() {
		return privacy;
	}

	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getInvitation() {
		return invitation;
	}

	public void setInvitation(String invitation) {
		this.invitation = invitation;
	}
	
	
}
