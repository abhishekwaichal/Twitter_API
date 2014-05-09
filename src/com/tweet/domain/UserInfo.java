/**
 * 
 */
package com.tweet.domain;

<<<<<<< HEAD
/*
 * import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
*/
=======
>>>>>>> 54121b55e375f1324838544e4198ccc2f19f35a8

/**
 * @author Abhishek
 *
 */
<<<<<<< HEAD
public class UserInfo {//implements UserDetails{
	
//	private static final long serialVersionUID = 1L;
	
=======
public class UserInfo {

>>>>>>> 54121b55e375f1324838544e4198ccc2f19f35a8
	private String username;

	private String pass;

<<<<<<< HEAD
	
	
=======
>>>>>>> 54121b55e375f1324838544e4198ccc2f19f35a8
	public UserInfo(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", pass=" + pass + "]";
	}
<<<<<<< HEAD
/*
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return pass;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
*/
=======
>>>>>>> 54121b55e375f1324838544e4198ccc2f19f35a8
}
