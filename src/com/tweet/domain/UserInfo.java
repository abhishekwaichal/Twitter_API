/**
 * 
 */
package com.tweet.domain;

/*
 * import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
*/

/**
 * @author Abhishek
 *
 */
public class UserInfo {//implements UserDetails{
	
//	private static final long serialVersionUID = 1L;
	

	private String username;

	private String pass;

	
	
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
}
