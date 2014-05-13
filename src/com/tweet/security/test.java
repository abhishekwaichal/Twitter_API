package com.tweet.security;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

public class test {
/*
	public String customEncode(String u, String p){
		
		String str = StringUtils.rightPad(u, 10, '|')+ StringUtils.rightPad(p, 10, '|'); 
		byte[]   bytesEncoded = Base64.encodeBase64(str .getBytes());
//		System.out.println("ecncoded value is " + new String(bytesEncoded ));
		return new String(bytesEncoded );
		
	}
*/	
	public static void main(String[] args) {

		String u = new String("userName");
		String p = new String("password"); 
		
		String str = StringUtils.rightPad(u, 10, '|')+ StringUtils.rightPad(p, 10, '|'); 
		
		// encrypt data on your side using BASE64
		byte[]   bytesEncoded = Base64.encodeBase64(str .getBytes());
		System.out.println("ecncoded value is " + new String(bytesEncoded ));

		
		// Decrypt data on other side, by processing encoded data
		byte[] valueDecoded= Base64.decodeBase64(bytesEncoded );
		System.out.println("Decoded value is " + new String(valueDecoded));
		
		String c = new String(valueDecoded);

		String u1 =  c.substring(10);
		System.out.println("Removed padding u: "+u1.replace("|", ""));
		
		String p1 =  c.substring(0,10);
		System.out.println("Removed padding u: "+p1.replace("|", ""));

	}


}
