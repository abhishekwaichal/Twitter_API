/**
 * 
 */
package com.tweet.service;

import java.util.List;

import com.tweet.domain.Tweet;
import com.tweet.domain.User;
import com.tweet.domain.UserInfo;

/**
 * @author Abhishek
 *
 */
public interface UserService {

	
	public User getUser(String userName);
	
	public UserInfo getUserInfo(String uName);
	
	public User getUser(Integer userId);
	

//    public UserInfo loadUserByUsername(final String username);
    public void testMeth();

	public void addTweet(Tweet tweet);

	public void deleteTweet(Integer id);

	public void updateTweet(Tweet tweet);
	
	

	public List<Tweet> readTweets(Integer userId);
	
	public List<Tweet> readSpeicificTweets(String text, Integer userId);
	
	public boolean followUser(Integer uid1, Integer uid2 );

	public boolean unfollowUser(Integer uid1, Integer uid2 );
	
	public List<User> getFollowersList(Integer uid1);

	public List<User> getFollowingList(Integer uid1);
	
	public List<User> getListofPeople(Integer uid);
}
