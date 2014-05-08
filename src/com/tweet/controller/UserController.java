/**
 * 
 */
package com.tweet.controller;


import java.util.List;
import java.util.Locale;
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
	
	@RequestMapping(value = "/login",  params = {"userId"})
	public ModelAndView UserEntry(@RequestParam(value = "userId") String uName) {

		User u = userService.getUser(uName);

		ModelAndView m = new ModelAndView("index");
		m.addObject("errMsg", "User does not exist. Please enter a valid user ID.");
		if(u == null){
			System.out.println("User does not exist !");
			return null;
		}
		
		ModelAndView mv = null;

		mv = new ModelAndView("Menu");

		mv.addObject("userID",u.getUserid());
		mv.addObject("email",u.getEmail());
		mv.addObject("name",u.getName());
		mv.addObject("userName",u.getUsername());
		
/*
 		userService.testMeth();
		userID1 = 1;
		if((userId.equals("admin")) && (password.equals("password"))){
			mv = new ModelAndView("Menu");
			mv.addObject("userID",2);
		}else{
			mv = new ModelAndView("error");
			mv.addObject("msg","Incorrect userId or password");
		}
*/
		return mv;
	}

	@RequestMapping(value = "/listpeople", params = {"userId"})
	public ModelAndView listpeople(@RequestParam(value = "userId") Integer uid) {		

		ModelAndView mv = null;

		mv = new ModelAndView("List");

		List<User> uList = userService.getListofPeople(uid);
		for(User r:uList)
				System.out.println(""+r.toString());

		String u = new String("Follow");
		mv.addObject("UID",uid);
		mv.addObject("uf",u);
		mv.addObject("uList",uList);

		return mv;
	}

	@RequestMapping(value = "/listpeople1", params = {"userId"})
	public ModelAndView listfollowing(@RequestParam(value = "userId") Integer uid) {		

		ModelAndView mv = null;

		mv = new ModelAndView("List");

		List<User> uList = userService.getFollowingList(uid);
		for(User r:uList)
				System.out.println(""+r.toString());

		String u = new String("Unfollow");
		mv.addObject("UID",uid);
		mv.addObject("uf",u);
		mv.addObject("uList",uList);

		return mv;
	}

	@RequestMapping(value = "/followuser", params = {"userId1","userId2"})
	public ModelAndView followUser(@RequestParam("userId1") Integer uid1, @RequestParam("userId2") Integer uid2) {
		return new ModelAndView("Menu");
	}
	
	@RequestMapping(value = "/unfollowuser", params = {"userId1","userId2"})
	public ModelAndView unfollowUser(@RequestParam("userId1") Integer uid1, @RequestParam("userId2") Integer uid2) {
		return new ModelAndView("Menu");
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