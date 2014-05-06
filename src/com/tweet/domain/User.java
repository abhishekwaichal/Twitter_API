/**
 * 
 */
package com.tweet.domain;


/**
 * @author Abhishek
 *
 */

public class User {

	private Integer userid;
	
	private String username;
	
	private String name;

	private String email;

	public User(Integer userid, String username, String name, String email) {
		super();
		this.userid = userid;
		this.username = username;
		this.name = name;
		this.email = email;
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
