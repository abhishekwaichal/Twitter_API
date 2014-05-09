/**
 * 
 */
package com.tweet.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.tweet.domain.Tweet;
import com.tweet.util.TweetMapper;

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

		String sql = "select tweet_id,tweet_text, poster_id from (select uid from users, follow where uid = follower_id and following_id = :uid ) f , tweets t where f.uid = poster_id";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",userId);

		RowMapper<Tweet> t1 = new TweetMapper();

		List<Tweet> t = namedParameterJdbcTemplate.query(sql, namedParameters, t1);

		
		
/*		for(Tweet t2 : t){
			System.out.println(""+t2);
		}
*/
		return t;
	}

	
	@Override
	public List<Tweet> getSpecificTweets(String str, Integer userId) {

		String sql = "select tweet_id,tweet_text, poster_id from (select uid from users, follow where uid = follower_id and following_id = :uid) f , tweets t where f.uid = poster_id and tweet_text like :str";

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("uid", userId);
		String text = "%"+str.trim();
		parameters.put("str", text);
 
//		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("uid", userId).addValue("str", str);

		RowMapper<Tweet> t1 = new TweetMapper();

		List<Tweet> t = namedParameterJdbcTemplate.query(sql, parameters, t1);
		System.out.println("Sz: "+t.size());
		
/*		for(Tweet t2 : t){
			System.out.println(""+t2);
		}
*/
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
