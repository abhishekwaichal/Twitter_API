/**
 * 
 */
package com.tweet.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
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

		RowMapper<User> user1 = new UserMapper();
	
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters,  user1);
	}

	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(Integer id) {
		// TODO Auto-generated method stub
		return false;		
	}

	

}
