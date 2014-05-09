/**
 * 
 */
package com.tweet.dao;

import java.util.List;

import com.tweet.domain.Tweet;

/**
 * 
 * @author Abhishek
 *
 * The MODEL
 * Tweet DAO:
 * Interacts with the database, and gets records from 'tweets' table.  
 * 
 */
public interface TweetDao {


	public void addTweet(Tweet tweet);

	public void deleteTweet(Integer id);

	public void updateTweet(Integer id);


	
	public List<Tweet> getTweets(Integer userId);

	public List<Tweet> getSpecificTweets(String txt, Integer userId);

	
}
