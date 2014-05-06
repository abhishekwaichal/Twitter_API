/**
 * 
 */
package com.tweet.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.tweet.domain.Tweet;

/**
 * @author Abhishek
 *
 */
@Repository
public class TweetDaoImpl implements TweetDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Tweet> getTweets(Integer userId) {

		String sql = "select * from tweets where poster_id  = :userId";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",userId);

		return namedParameterJdbcTemplate.queryForList(sql, namedParameters,
				Tweet.class);
	}

	
	//---------------------------------------------//
	@Override
	public List<Tweet> getSpecificTweets(String str, Integer userId) {

		String sql = "select * from tweets where poster_id  = :userId";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",userId);

		return namedParameterJdbcTemplate.queryForList(sql, namedParameters,
				Tweet.class);
	}

	
	
	@Override
	public void addTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTweet(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTweet(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
