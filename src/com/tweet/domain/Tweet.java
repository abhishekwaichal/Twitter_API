/**
 * 
 */
package com.tweet.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * @author Abhishek
 *
 */

@XmlRootElement(name = "tweets")
public class Tweet {
	
	private Integer tweet_id;
	
	private String tweet_text;
	
	private Integer poster_id;

	public Tweet(Integer tweet_id, String tweet_text, Integer poster_id) {
		super();
		this.tweet_id = tweet_id;
		this.tweet_text = tweet_text;
		this.poster_id = poster_id;
	}

	public Integer getTweet_id() {
		return tweet_id;
	}

	@XmlElement
	public void setTweet_id(Integer tweet_id) {
		this.tweet_id = tweet_id;
	}

	public String getTweet_text() {
		return tweet_text;
	}


	@XmlElement
	public void setTweet_text(String tweet_text) {
		this.tweet_text = tweet_text;
	}

	public Integer getPoster_id() {
		return poster_id;
	}


	@XmlElement
	public void setPoster_id(Integer poster_id) {
		this.poster_id = poster_id;
	}

	@Override
	public String toString() {
		return "Tweet [tweet_id=" + tweet_id + ", tweet_text=" + tweet_text
				+ ", poster_id=" + poster_id + "]";
	}

}
