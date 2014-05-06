/**
 * 
 */
package com.tweet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tweet.dao.TweetDao;
import com.tweet.domain.Tweet;

/**
 * @author Abhishek
 *
 */
@Service
public class TweetServiceImpl implements TweetService {

	
	@Autowired
	TweetDao tweetDao;
	

	@Transactional
	@Override
	public List<Tweet> getTweets(Integer userId) {

		return tweetDao.getTweets(userId);
		
	}

	@Transactional
	@Override
	public List<Tweet> getSpecificTweets(Integer userId, String txt) {

		return tweetDao.getSpecificTweets(txt, userId);
		
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
	public void updateTweet(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
