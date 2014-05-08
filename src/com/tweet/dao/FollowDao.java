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
	
	public boolean addFollow(Follow f);

	public boolean deleteFollow(Follow f);

	public boolean updateFollower(Follow f);

	
	public List<User> getFollowers(Integer userId);

	public List<User> getFollowing(Integer userId);

	public List<User> getListofPeople(Integer uid);
}
