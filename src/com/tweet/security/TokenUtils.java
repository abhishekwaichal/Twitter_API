/**
 * 
 */
package com.tweet.security;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Abhishek
 * 
 */
public interface TokenUtils {
	String getToken(UserDetails userDetails);

	String getToken(UserDetails userDetails, Long expiration);

	boolean validate(String token);

	UserDetails getUserFromToken(String token);
}
