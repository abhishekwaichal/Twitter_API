/**
 * 
 */
package com.tweet.domain;



/**
 * @author Abhishek
 *
 */


public class Tweet {
	
	private int tweet_id;
	
	private String text;
	
	private User poster;

	
	public int getTweet_id() {
		return tweet_id;
	}

	public void setTweet_id(int tweet_id) {
		this.tweet_id = tweet_id;
	}

	public Tweet(String text, User poster, String dateTime) {
		super();
		this.text = text;
		this.poster = poster;
	}


	public void setPoster(User poster) {
		this.poster = poster;
	}

	public User getPoster() {
		return poster;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Tweet [text=" + text + ", poster=" + poster + "]";
	}


}
