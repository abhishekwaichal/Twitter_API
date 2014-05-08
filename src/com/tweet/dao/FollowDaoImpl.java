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

import com.tweet.domain.Follow;
import com.tweet.domain.User;
import com.tweet.util.UserMapper;

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

		String sql = "select uid, uname, email, name from users, follow where uid = follower_id and following_id = :uid and uid <> :uid";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",userId);

		RowMapper<User> u1 = new UserMapper();

		List<User> u = namedParameterJdbcTemplate.query(sql, namedParameters, u1);

		return u;
	}

	@Override
	public List<User> getFollowing(Integer userId) {

		String sql = "select uid, uname, email, name from users, follow where uid = following_id and follower_id = :uid and uid <> :uid";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",userId);

		RowMapper<User> u1 = new UserMapper();

		List<User> u = namedParameterJdbcTemplate.query(sql, namedParameters, u1);

		
		
		return u;
	}


	@Override
	public boolean addFollow(Follow f) {

//		System.out.println("In Add"+f.getFollower()+""+f.getFollowing());
		String sql = "INSERT INTO follow (follower_id,following_id) VALUES (:follower_id, :following_id)";
		
		Map<String, Integer> namedParameters = new HashMap<String, Integer>();

		namedParameters.put("follower_id", f.getFollower());
		namedParameters.put("following_id", f.getFollowing());
		

		int ret = namedParameterJdbcTemplate.update(sql, namedParameters);
		
		if(ret < 1){
			System.out.println("Not inserted !");
			return false;}
		return true;

}


	@Override
	public boolean deleteFollow(Follow f) {

//		System.out.println("In Del"+f.getFollower()+""+f.getFollowing());		
		String sql = "DELETE FROM follow WHERE following_id = :following_id and follower_id = :follower_id";
		
		Map<String, Integer> namedParameters = new HashMap<String, Integer>();

		namedParameters.put("follower_id", f.getFollower());
		namedParameters.put("following_id", f.getFollowing());

		int ret = namedParameterJdbcTemplate.update(sql, namedParameters);
		
		if(ret < 1){
			System.out.println("Not inserted !");
			return false;}
		return true;
		
}



	@Override
	public List<User> getListofPeople(Integer uId) {

		String sql = "select * from users s where s.uid NOT in (select uid from users, follow where uid = following_id and follower_id = :uid)";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",uId);

		RowMapper<User> u1 = new UserMapper();

		List<User> u = namedParameterJdbcTemplate.query(sql, namedParameters, u1);

		return u;
	}
	

	@Override
	public boolean updateFollower(Follow f) {
		// TODO Auto-generated method stub
		
		return false;
	}
}
