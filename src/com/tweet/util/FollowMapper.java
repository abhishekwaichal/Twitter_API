/**
 * 
 */
package com.tweet.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tweet.domain.Follow;

/**
 * @author Abhishek
 *
 */
public class FollowMapper implements RowMapper<Follow> {

	@Override
	public Follow mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		return new Follow(resultSet.getInt("follower_id"),resultSet.getInt("following_id") );

	}

}
