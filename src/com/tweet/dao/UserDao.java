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

	public boolean addUser(User user);

	public boolean deleteUser(Integer userId);

	public boolean updateUser(Integer userId);

	
	public User getUser(Integer userId);
	
	public User getUser(String userName);
	
	
/*    public List<User> getFollowers(Integer userId);

    public List<User> getFollowed(Integer userId);
    
    public void updateFollowers(List<User> followers);
*/
}
