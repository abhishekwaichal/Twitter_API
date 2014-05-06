/**
 * 
 */
package com.tweet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.tweet.domain.Follow;
import com.tweet.domain.User;

/**
 * @author Abhishek
 *
 */

@Repository
public class FollowDaoImpl implements FollowDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}


	@Override
	public List<User> getFollowers(Integer userId) {

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid", Integer.valueOf(userId));

		StringBuffer recordQueryString = new StringBuffer();

		recordQueryString
				.append("select following_id from follow where follower_id = :uid) ");

		List<User> followedList = namedParameterJdbcTemplate.query(
				recordQueryString.toString(), namedParameters, new RowMapper() {
					public Object mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return userDao.getUser(resultSet.getInt("following_id"));
					}
				});
		return followedList;
	}

	@Override
	public List<User> getFollowing(Integer userId) {

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid", Integer.valueOf(userId));

		StringBuffer recordQueryString = new StringBuffer();

		recordQueryString
				.append("select follower_id from follow where following_id = :uid) ");

		List<User> followedList = namedParameterJdbcTemplate.query(
				recordQueryString.toString(), namedParameters, new RowMapper() {
					public Object mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return userDao.getUser(resultSet.getInt("follower_id"));
					}
				});
		return followedList;
	}


	@Override
	public void addFollower(Follow f) {

		String sql = "INSERT INTO follow (`follower_id`,`following_id`) VALUES (:following, :follower)";
		
		Map namedParameters = new HashMap();

		namedParameters.put("following", Integer.valueOf(f.getFollowing().getUserid()));
		namedParameters.put("follower", Integer.valueOf(f.getFollower().getUserid()));

		namedParameterJdbcTemplate.update(sql, namedParameters);

}


	@Override
	public void deleteFollower(Follow f) {
	
		String sql = "DELETE FROM follow WHERE following = :following_id and follower = :follower_id;";
		
		Map namedParameters = new HashMap();

		namedParameters.put("following", Integer.valueOf(f.getFollowing().getUserid()));
		namedParameters.put("follower", Integer.valueOf(f.getFollower().getUserid()));

		namedParameterJdbcTemplate.update(sql, namedParameters);

		
}

	

	@Override
	public void updateFollower(Follow f) {
		// TODO Auto-generated method stub
		
	}
}
