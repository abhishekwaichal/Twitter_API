/**
 * 
 */
package com.tweet.service;

import java.util.List;

import com.tweet.domain.Tweet;

/**
 * @author Abhishek
 * 
 */
public interface TweetService {
	
	public abstract void addTweet(Tweet tweet);

	public abstract void deleteTweet(Integer id);

	public abstract void updateTweet(Integer id);


	public abstract List<Tweet> getTweets(Integer uid);

	public abstract List<Tweet> getSpecificTweets(Integer uid, String txt);

}
