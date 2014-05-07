/**
 * 
 */
package com.tweet.dao;

import java.util.List;

import com.tweet.domain.Tweet;

/**
 * @author Abhishek
 *
 */
public interface TweetDao {


	public void addTweet(Tweet tweet);

	public void deleteTweet(Integer id);

	public void updateTweet(Integer id);


	
	public List<Tweet> getTweets(Integer userId);

	public List<Tweet> getSpecificTweets(String txt, Integer userId);

	
}
