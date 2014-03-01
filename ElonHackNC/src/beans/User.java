/*
 * Copyright (c) Thomas Robbins, Schuyler Goodwin, Miles Camp, Evan Walmer March 1, 2014
 */

package beans;

import java.sql.PreparedStatement;

public class User {
	private String username = "";
	private String email = "";
	private String password = "";
	private String message = "";

	private String github = "";
	private String pictureURL = "";
	private String personalWeb = "";

	public User() {

	}

	public User(String username, String email, String password) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String username, String email, String password, String github,
			String pictureURL, String personalWeb) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.github = github;
		this.pictureURL = pictureURL;
		this.personalWeb = personalWeb;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String user) {
		this.username = user;
	}

	public String getMessage() {
		return message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean validate() {

		if (!email.matches("\\w+@\\w+\\.\\w+")) {
			message = "Invalid email address : " + email;
			return false;
		}

		if (password.length() < 8) {
			message = "Password must be at least 8 characters long";
			return false;
		} else if (password.contains(" ")) {
			message = "Password cannot contain spaces";
			return false;
		}
		return true;
	}

}
