/**
 * 
 */
package com.tweet.service;

import java.util.List;

import com.tweet.domain.Tweet;
import com.tweet.domain.User;


/**
 * @author Abhishek
 *
 */
public interface UserService {

	public abstract void testMeth();

	public abstract void addTweet(Tweet tweet);

	public abstract void deleteTweet(Integer id);

	public abstract void updateTweet(Tweet tweet);
	
	

	public abstract List<Tweet> readTweets(Integer userId);
	
	public abstract List<Tweet> readSpeicificTweets(String text, Integer userId);
	
	public abstract boolean followUser(Integer uid1, Integer uid2 );

	public abstract boolean unfollowUser(Integer uid1, Integer uid2 );
	
	public abstract List<User> getFollowersList(Integer uid1);

	public abstract List<User> getFollowingList(Integer uid1);
	

}
