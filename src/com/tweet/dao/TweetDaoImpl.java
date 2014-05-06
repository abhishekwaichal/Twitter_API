/**
 * 
 */
package com.tweet.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
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

		String sql = "select uid, uname, email, name from users, follow where uid = follower_id and following_id = :uid";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",userId);

		RowMapper<Tweet> t1 = new TweetMapper();

		List<Tweet> t = namedParameterJdbcTemplate.query(sql, namedParameters, t1);

		return t;

	}

	
	@Override
	public List<Tweet> getSpecificTweets(String str, Integer userId) {

		String sql = "select uid, uname, email, name from users, follow where uid = follower_id and following_id = :uid";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",userId);

		RowMapper<Tweet> t1 = new TweetMapper();

		List<Tweet> t = namedParameterJdbcTemplate.query(sql, namedParameters, t1);

		return t;

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
