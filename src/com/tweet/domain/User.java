/**
 * 
 */
package com.tweet.domain;


/**
 * 
 * @author Abhishek
 * 
 * User:
 * Serves to hold 'users' values from records retrieved from database table 'users'.   
 * Part of MODEL  layer
 * 
 */

public class User {

	private Integer userid;
	
	private String username;
	
	private String email;

	private String name;

	public User(Integer userid, String username, String email, String name ) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.name = name;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", name="
				+ name + ", email=" + email + "]";
	}
}
