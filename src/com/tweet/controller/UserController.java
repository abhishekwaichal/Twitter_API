/**
 * 
 */
package com.tweet.controller;


import java.util.List;
import java.util.Locale;

import javax.websocket.Session;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tweet.domain.Tweet;
import com.tweet.domain.User;
import com.tweet.service.UserService;

/**
 * @author Abhishek
 * 
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;

	Integer userID1;
	
	@RequestMapping(value = "/login",  params = {"userId", "password"})
	public ModelAndView firstTestMeth(@RequestParam(value = "userId") String uid, @RequestParam(value = "password") String pass) {

		
		
		ModelAndView mv = null;

		String userId =   uid;
		String password = pass;

		userService.testMeth();
		
		userID1 = 1;
		
		if((userId.equals("admin")) && (password.equals("password"))){
			mv = new ModelAndView("Menu");
			mv.addObject("userID",2);
		}else{
			mv = new ModelAndView("error");
			mv.addObject("msg","Incorrect userId or password");
		}

		return mv;
	}

	@RequestMapping(value = "/listpeople", params = {"userId"})//method = RequestMethod.GET)
	@ResponseBody
	public List<User>listpeople(@RequestParam(value = "userId") Integer uid) {		
		return userService.getListofPeople(uid);
//		System.out.println("LOLA");
//		return "success";
	}
	
	@RequestMapping(value = "/followuser", params = {"userId1","userId2"})
	@ResponseBody
	public boolean followUser(@RequestParam("userId1") Integer uid1, @RequestParam("userId2") Integer uid2) {
		return userService.followUser(uid1, uid2);
	}
	
	@RequestMapping(value = "/unfollowuser", params = {"userId1","userId2"})
	@ResponseBody
	public boolean unfollowUser(@RequestParam("userId1") Integer uid1, @RequestParam("userId2") Integer uid2) {
		return userService.unfollowUser(uid1, uid2);
	}
	
	@RequestMapping(value = "/listfollowers", params = {"userId"})
	@ResponseBody
	public List<User> listFollowers(@RequestParam("userId") Integer uid1) {
		return userService.getFollowersList(uid1);
	}

	@RequestMapping(value = "/listfollowing", params = {"userId"})
	@ResponseBody
	public List<User> listFollowing(@RequestParam("userId") Integer uid1) {
		return userService.getFollowingList(uid1);
	}
	
	@RequestMapping(value = "/readTweets", params = {"userId"})	
	public @ResponseBody List<Tweet> readTweets(@RequestParam("userId") Integer uid1) {

//		return userService.getUser(userId);
		
		List<Tweet> t = userService.readTweets(uid1);
		
/*	for(Tweet t2 : t){
		System.out.println(""+t2);
	}
*/
		return t;
	}
	
	@RequestMapping(value = "/readSpecificTweets", params = {"userId","text"})
	@ResponseBody
	public List<Tweet> readSpecificTweets(@RequestParam("userId") Integer uid1, @RequestParam("text") String text) {
		return userService.readSpeicificTweets(text, uid1);
	}
	
}