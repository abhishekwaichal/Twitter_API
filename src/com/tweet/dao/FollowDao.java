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
	
	public abstract boolean addFollower(Follow f);

	public abstract boolean deleteFollower(Follow f);

	public abstract boolean updateFollower(Follow f);

	
	public abstract List<User> getFollowers(Integer userId);

	public abstract List<User> getFollowing(Integer userId);

	public abstract List<User> getListofPeople(Integer uid);
}
