package com.casestudy.tlta.entity;

public enum Role {
	USER("User"),

	

	MODERATOR("Moderator") ,

	ADMIN("Admin");
	
private String role;
	
	private Role(String role) {
		this.role=role;
	}

	public String getRole() {
		return role;
	}
	

}
