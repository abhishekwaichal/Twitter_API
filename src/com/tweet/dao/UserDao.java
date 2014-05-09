/**
 * 
 */
package com.tweet.dao;

import com.tweet.domain.User;
import com.tweet.domain.UserInfo;

/**
 * 
 * @author Abhishek
 * 
 * The MODEL
 * User DAO:
 * Interacts with the database, and gets records from 'users' and 'master_login'table.  
 * 
 */

public interface UserDao {

	public boolean addUser(User user);

	public boolean deleteUser(Integer userId);

	public boolean updateUser(Integer userId);

	public UserInfo getUserInfo(String uName);
	
	public User getUser(Integer userId);
	
	public User getUser(String userName);
	
}
