/**
 * 
 */
package com.tweet.service;

import java.util.List;

import com.tweet.domain.Tweet;
/**
 * 
 * @author Abhishek
 * 
 * SERVICE Layer
 * TweetService:
 * Provides all tweets related services.   
 * 
 */

public interface TweetService {
	
	public void addTweet(Tweet tweet);

	public void deleteTweet(Integer id);

	public void updateTweet(Integer id);


	public List<Tweet> getTweets(Integer uid);

	public List<Tweet> getSpecificTweets(Integer uid, String txt);

}
