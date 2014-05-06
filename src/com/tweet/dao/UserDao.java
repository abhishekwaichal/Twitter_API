/**
 * 
 */
package com.tweet.dao;

import com.tweet.domain.User;

/**
 * @author Abhishek
 *
 */
public interface UserDao {

	public abstract boolean addUser(User user);

	public abstract boolean deleteUser(Integer userId);

	public abstract boolean updateUser(Integer userId);

	
	public abstract User getUser(Integer userId);
	
/*    public abstract List<User> getFollowers(Integer userId);

    public abstract List<User> getFollowed(Integer userId);
    
    public abstract void updateFollowers(List<User> followers);
*/
}
