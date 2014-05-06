/**
 * 
 */
package com.tweet.dao;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.tweet.domain.User;

/**
 * @author Abhishek
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public User getUser(Integer userId) {

		String sql = "select * from users where uid = :uid";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",userId);

		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters,
				User.class);
	}

/*	@Override
	public List<User> getFollowers(Integer userId) {

		String sql = "select follower_id from follow where following_id  = :userId";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",userId);

		return namedParameterJdbcTemplate.queryForList(sql, namedParameters,
				User.class);

	}

	@Override
	public List<User> getFollowed(Integer userId) {

		String sql = "select following_id from follow where follower_id  = :userId";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",userId);

		return namedParameterJdbcTemplate.queryForList(sql, namedParameters,
				User.class);
	}

	@Override
	public void updateFollowers(List<User> followers) {
		
	}
*/
	
	
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(Integer id) {
		// TODO Auto-generated method stub
		
	}

	

}
