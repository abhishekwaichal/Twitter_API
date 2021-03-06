/**
 * 
 */
package com.tweet.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.tweet.domain.User;
import com.tweet.util.UserInfoMapper;
import com.tweet.util.UserMapper;
import com.tweet.domain.UserInfo;
/**
 * 
 * @author Abhishek
 * 
 * User DAO Implementation:
 * Interacts with the database, and gets records from 'users' and 'master_login'table.  
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
	public User getUser(String userName) {

		String sql = "select * from users where uname = :uname";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uname",userName);

		RowMapper<User> user1 = new UserMapper();
		User u ;
		try {
			u = namedParameterJdbcTemplate.queryForObject(sql, namedParameters,  user1);
		} catch (IncorrectResultSizeDataAccessException e) {
			System.out.println("NO USER");
			return null;
		}
		catch (DataAccessException e) {
			System.out.println("NO USER");
			return null;
		}
		return u;	
		
	}


	@Override
	public UserInfo getUserInfo(String uName) {

		String sql = "select * from master_login where user_id = :uname";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uname",uName);

		RowMapper<UserInfo> userInf = new UserInfoMapper();
		UserInfo u ;
		try {
			u = namedParameterJdbcTemplate.queryForObject(sql, namedParameters,  userInf);
		} catch (IncorrectResultSizeDataAccessException e) {
			System.out.println("NO USER !!!!!!");
			return null;
		}
		catch (DataAccessException e) {
			System.out.println("NO USER !!!!!!");
			return null;
		}
		return u;	
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
