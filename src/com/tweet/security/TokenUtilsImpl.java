/**
 * 
 */
package com.tweet.security;

import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import com.tweet.dao.UserDao;
import com.tweet.domain.UserInfo;

/**
 * @author Abhishek
 *
 */
public class TokenUtilsImpl implements TokenUtils {

	@Autowired
	UserDao userDao;


	@Override
	public String getToken(UserDetails userDetails) {

		String u = userDetails.getUsername();
		String p = userDetails.getPassword();
		String str = StringUtils.rightPad(u, 16, '|')
				+ StringUtils.rightPad(p, 16, '|');
		byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());

		return new String(bytesEncoded);

	}

	@Override
	public String getToken(UserDetails userDetails, Long expiration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate(String token) {

		// Decrypt data on other side, by processing encoded data
		byte[] valueDecoded = Base64.decodeBase64(token);

		String c = new String(valueDecoded);

		String u1 =  c.substring(0,15);  // Username is max 32 bits and padded till 64th bit with '|' 
		String p1 =  c.substring(15);	// Password is rest

//		System.out.println("Decoded value is " + new String(valueDecoded));

		UserInfo userRetrieved = userDao.getUserInfo(u1);
		
		if(userRetrieved.getPass().equals(p1)){
			return true;
		}
		return false;
	}

	@Override
	public UserDetails getUserFromToken(String token) {
		
		byte[] valueDecoded= Base64.decodeBase64(token);
		System.out.println("Decoded value is " + new String(valueDecoded));

		String c = new String(valueDecoded);

		String u1 =  c.substring(0,31);  // Username is max 32 bits and padded till 64th bit with '|' 
		UserInfo u = userDao.getUserInfo(u1);
		
		return u;
	}

}
