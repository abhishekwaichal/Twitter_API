/**
 * 
 */
package com.tweet.dao;

import java.util.List;
import com.tweet.domain.Follow;
import com.tweet.domain.User;

/**
 * @author Abhishek
 *
 */
public interface FollowDao {
	
	public abstract void addFollower(Follow f);

	public abstract void deleteFollower(Follow f);

	public abstract void updateFollower(Follow f);

	
	public abstract List<User> getFollowers(Integer userId);

	public abstract List<User> getFollowing(Integer userId);

	
}
