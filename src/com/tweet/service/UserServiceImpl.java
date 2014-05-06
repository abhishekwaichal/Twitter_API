/**
 * 
 */
package com.tweet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.dao.FollowDao;
import com.tweet.dao.TweetDao;
import com.tweet.dao.UserDao;
import com.tweet.domain.Follow;
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
		System.out.println("In service layer ! !!!!!!!!!!!!");
		Follow f = new Follow(4, 5);
		followDao.deleteFollower(f);
		
	}
	
	
/*
	@Transactional
	@Override
	public List<User> getFollowersList(Integer userId1) {

		return followDao.getFollowers(userId1);
		
	}

	@Transactional
	@Override
	public List<User> getFollowingList(Integer userId1) {

		return followDao.getFollowing(userId1);

	}

	@Transactional
	@Override
	public boolean followUser(Integer userId1, Integer userId2) {

		User user1 = userDao.getUser(userId1);
		User user2 = userDao.getUser(userId2);
		Follow f = new Follow(user1, user2);
		followDao.addFollower(f);
		return true;
	}

	@Transactional
	@Override
	public boolean unfollowUser(Integer userId1, Integer userId2) {

		User user1 = userDao.getUser(userId1);
		User user2 = userDao.getUser(userId2);
		Follow f = new Follow(user1, user2);
		followDao.deleteFollower(f);
		return true;

	}

	@Transactional	
	@Override
	public List<Tweet> readTweets(Integer userId) {

		return tweetDao.getTweets(userId);

	}

	@Transactional
	@Override
	public List<Tweet> readSpeicificTweets(String text, Integer userId) {

		return tweetDao.getSpecificTweets(text, userId);

	}

	

	@Transactional
	@Override
	public void addTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void deleteTweet(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void updateTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		
	}

*/	
}
