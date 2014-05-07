/**
 * 
 */
package com.tweet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tweet.domain.Tweet;

/**
 * @author Abhishek
 *
 */
public class TweetMapper implements RowMapper<Tweet>{

	@Override
	public Tweet mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		return new Tweet(resultSet.getInt("tweet_id"),
				resultSet.getString("tweet_text"),
				resultSet.getInt("poster_id"));
	}

	
}
