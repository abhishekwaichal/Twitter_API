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

/*	@Override
	public List<User> getFollowers(Integer userId) {

		String sql = "select uid, uname, email, name from users, follow where uid = follower_id and following_id = :uid";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",userId);

		RowMapper<User> u1 = new UserMapper();

		List<User> u = namedParameterJdbcTemplate.query(sql, namedParameters, u1);

		return u;
		
	}

	@Override
	public List<User> getFollowed(Integer userId) {

		String sql = "select uid, uname, email, name from users, follow where uid = following_idand  follower_id = :uid";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",userId);

		RowMapper<User> u1 = new UserMapper();

		List<User> u = namedParameterJdbcTemplate.query(sql, namedParameters, u1);

		return u;
		
	}

	@Override
	public void updateFollowers(List<User> followers) {
		
	}
	
*/	
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub

/*		String sql = "select * from follow where following_id = :uid";

		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",user.getUserid());

		RowMapper<Follow> f1 = new FollowMapper();

		List<Follow> u = namedParameterJdbcTemplate.query(sql, namedParameters, f1);
		
		for(Follow u1: u){
			System.out.println(" "+u1);
		}
*/		
		
//		for(User u1:u){
//			System.out.println(""+u1.toString());
//		}

		
		/*		System.out.println("In DAO layer ! ");
		
		String sql = "select * from users where uid = :uid";
		SqlParameterSource namedParameters = new MapSqlParameterSource("uid",user.getUserid());
		RowMapper<User> user1 = new UserMapper();
		System.out.println(namedParameterJdbcTemplate.queryForObject(sql, namedParameters,  user1).toString());

*/		
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
