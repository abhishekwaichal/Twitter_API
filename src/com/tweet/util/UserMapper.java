/**
 * 
 */
package com.tweet.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.tweet.domain.User;

/**
 * 
 * @author Abhishek
 * 
 * UserMaper:
 * Maps retrieved 'users' records to 'User' java objects.    
 * 
 */

	public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		return new User(resultSet.getInt("uid"), resultSet.getString("uname"),
				resultSet.getString("email"), resultSet.getString("name"));

	}

}
