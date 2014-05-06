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


	public abstract void addTweet(Tweet tweet);

	public abstract void deleteTweet(Integer id);

	public abstract void updateTweet(Integer id);


	
	public abstract List<Tweet> getTweets(Integer userId);

	public abstract List<Tweet> getSpecificTweets(String txt, Integer userId);

	
}
