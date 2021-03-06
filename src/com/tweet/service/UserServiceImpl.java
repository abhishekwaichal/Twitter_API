/**
 * 
 */
package com.tweet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import com.tweet.dao.FollowDao;
import com.tweet.dao.TweetDao;
import com.tweet.dao.UserDao;
import com.tweet.domain.Follow;
import com.tweet.domain.Tweet;
import com.tweet.domain.User;
import com.tweet.domain.UserInfo;


/**
 * 
 * @author Abhishek
 * 
 * SERVICE Layer
 * UserService Implementation:
 * Provides all User related services.   
 * 
 */

@Service
public class UserServiceImpl implements UserService{//, UserDetailsService{
	

	
	@Autowired
	UserDao userDao;

	@Autowired
	TweetDao tweetDao;

	@Autowired
	FollowDao followDao;

	public void testMeth(){
		String str= new String("TCD");
		System.out.println("In service layer ! !!!!!!!!!!!!");
		tweetDao.getSpecificTweets(str, 2);
	}
	
	@Override
	public User getUser(String userName) {

		return userDao.getUser(userName);
		
	}
	
	@Override
	public User getUser(Integer userId) {
		return userDao.getUser(userId);
	}
	
	@Override
	public UserInfo getUserInfo(String uName) {
		return userDao.getUserInfo(uName);
	}



	@Override
	public List<User> getFollowersList(Integer userId1) {
		return followDao.getFollowers(userId1);
	}

	@Override
	public List<User> getFollowingList(Integer userId1) {
		return followDao.getFollowing(userId1);
	}

	@Override
	public boolean followUser(Integer userId1, Integer userId2) {
		Follow f = new Follow(userId1, userId2);
		followDao.addFollow(f);
		return true;
	}

	@Override
	public boolean unfollowUser(Integer userId1, Integer userId2) {
		Follow f = new Follow(userId1, userId2);
		followDao.deleteFollow(f);
		return true;
	}

	@Override
	public List<Tweet> readTweets(Integer userId) {
		return tweetDao.getTweets(userId);
	}

	@Override
	public List<Tweet> readSpeicificTweets(String text, Integer userId) {
		return tweetDao.getSpecificTweets(text, userId);
	}


	@Override
	public List<User> getListofPeople(Integer uid) {
		return followDao.getListofPeople(uid);
		}

	
	@Override
	public void addTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTweet(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		
	}

/*	@Override
	public UserInfo loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
	
		return userDao.getUserInfo(username);
		
		
	}

*/	
}
