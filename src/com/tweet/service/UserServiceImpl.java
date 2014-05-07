/**
 * 
 */
package com.tweet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.dao.FollowDao;
import com.tweet.dao.TweetDao;
import com.tweet.dao.UserDao;
import com.tweet.domain.Follow;
import com.tweet.domain.Tweet;
import com.tweet.domain.User;



/**
 * @author Abhishek
 *
 */
@Service
public class UserServiceImpl implements UserService {
	

	
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
		followDao.addFollower(f);
		return true;
	}

	@Override
	public boolean unfollowUser(Integer userId1, Integer userId2) {
		Follow f = new Follow(userId1, userId2);
		followDao.deleteFollower(f);
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
	
}
