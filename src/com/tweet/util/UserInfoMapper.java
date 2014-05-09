/**
 * 
 */
package com.tweet.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tweet.domain.UserInfo;

/**
 * 
 * @author Abhishek
 * 
 * UserMaper:
 * Maps retrieved 'master_login' records to 'UserInfo' java objects.    
 * 
 */
	public class UserInfoMapper implements RowMapper<UserInfo> {

	@Override
	public UserInfo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		return  new UserInfo(resultSet.getString("user_id"), resultSet.getString("passwd"));

	}
	}
