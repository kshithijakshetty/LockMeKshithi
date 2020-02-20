package com.kshithija.model;

public class UserCredentials {

	private String websiteName;
	private String currentUser;	
	private String username;
	private String password;
	
	public UserCredentials() {}
	
	public String getWebsiteName() {
		return websiteName;
	}
	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}
	public String getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserCredentials(String websiteName, String currentUser, String username, String password) {
		super();
		this.websiteName = websiteName;
		this.currentUser = currentUser;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserCredentials [websiteName=" + websiteName + ", currentUser=" + currentUser + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	}
	
	
	
	


