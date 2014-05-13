/**
 * 
 */
package com.tweet.controller;

import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.tweet.domain.Tweet;
import com.tweet.domain.User;
import com.tweet.security.TokenUtils;
import com.tweet.security.TokenUtilsImpl;
import com.tweet.service.UserService;
import com.tweet.domain.UserInfo;

/**
 * 
 * @author Abhishek
 * 
 * The CONTROLLER
 * UserController:
 * Handles all the requests from the view and delegates the 
 * requests to DAO layer via SERVICE LAYER.
 *   
 */
@Controller
@SessionAttributes("sessionUser")
public class UserController {

	@Autowired
	UserService userService;

	HttpSession session;
/*
 * 
 * Handles the request from current user to log in to the system from view
 * 
*/	

	@RequestMapping(value = "/login", params = { "userId", "password" })
	public ModelAndView UserEntry(@RequestParam(value = "userId") String uName,
			@RequestParam(value = "password") String pass,
			HttpServletRequest request, HttpServletResponse response) {

		User u = userService.getUser(uName);
		UserInfo ui = userService.getUserInfo(uName);

		ModelAndView mv2 = new ModelAndView("error");
		if (u == null || ui == null) {
			mv2.addObject("msg", "User not found");
			return mv2;
		}

		if (!ui.getPass().equals(pass) || !ui.getUsername().equals(uName)) {
			System.out.println("Invalid U/P !");
			mv2.addObject("msg", "Invalid username and/or password !");
			return mv2;
		}
		TokenUtils t = new TokenUtilsImpl();
		String Token = t.getToken(ui);

		ModelAndView mv = new ModelAndView("Menu");
		mv.addObject("userID", u.getUserid());
		mv.addObject("email", u.getEmail());
		mv.addObject("name", u.getName());
		mv.addObject("userName", u.getUsername());
		mv.addObject("token", Token);

		return mv;
	}


	@RequestMapping(value = "/logout")
	public ModelAndView userExit(){
		System.out.println("In logout controller");
		session.invalidate();
		return new ModelAndView("index");
	}

	/*
	 * 
	 * Handles the request to list of the people that can be followed by current user
	 *  
	*/	
	@RequestMapping(value = "/listpeople", params = { "userId" })
	public ModelAndView listpeople(@RequestParam(value = "userId") Integer uid) {

		ModelAndView mv = null;

		mv = new ModelAndView("List");

		List<User> uList = userService.getListofPeople(uid);
		for (User r : uList)
			System.out.println("" + r.toString());

		String u = new String("Follow");
		String action = new String("followuser");
		mv.addObject("act", action);
		mv.addObject("UID", uid);
		mv.addObject("uf", u);
		mv.addObject("uList", uList);

		return mv;
	}

	/*
	 * 
	 * Handles the request to list of the people that can be unfollowed by current user
	 *  
	*/	
	@RequestMapping(value = "/listpeople1", params = { "userId" })
	public ModelAndView listfollowing(
			@RequestParam(value = "userId") Integer uid) {

		ModelAndView mv = null;

		mv = new ModelAndView("List");

		List<User> uList = userService.getFollowingList(uid);
		for (User r : uList)
			System.out.println("" + r.toString());

		String u = new String("Unfollow");
		String action = new String("unfollowuser");
		mv.addObject("act", action);
		mv.addObject("UID", uid);
		mv.addObject("uf", u);
		mv.addObject("uList", uList);

		return mv;
	}

	/*
	 * 
	 * Handles the request to follow a user by current user
	 *  
	*/	
	@RequestMapping(value = "/followuser", params = { "userId1", "userId2" })
	public ModelAndView followUser(@RequestParam("userId1") Integer uid1,
			@RequestParam("userId2") Integer uid2) {

		userService.followUser(uid1, uid2);

		User u = userService.getUser(uid1);
		ModelAndView mv = null;
		mv = new ModelAndView("Menu");
		mv.addObject("userID", u.getUserid());
		mv.addObject("email", u.getEmail());
		mv.addObject("name", u.getName());
		mv.addObject("userName", u.getUsername());
		return mv;

	}

	/*
	 * 
	 * Handles the request to unfollow a user by current user
	 *  
	*/	
	@RequestMapping(value = "/unfollowuser", params = { "userId1", "userId2" })
	public ModelAndView unfollowUser(@RequestParam("userId1") Integer uid1,
			@RequestParam("userId2") Integer uid2) {
		userService.unfollowUser(uid1, uid2);
		User u = userService.getUser(uid1);

		ModelAndView mv = null;

		mv = new ModelAndView("Menu");

		mv.addObject("userID", u.getUserid());
		mv.addObject("email", u.getEmail());
		mv.addObject("name", u.getName());
		mv.addObject("userName", u.getUsername());
		return mv;

	}

	/*
	 * 
	 * Handles the request to followers of current user
	 *  
	*/	
	@RequestMapping(value = "/listfollowers", params = { "userId" })
	@ResponseBody
	public List<User> listFollowers(@RequestParam("userId") Integer uid1) {
		return userService.getFollowersList(uid1);
	}

	/*
	 * 
	 * Handles the request to follow by a user
	 *  
	*/	
	@RequestMapping(value = "/listfollowing", params = { "userId" })
	@ResponseBody
	public List<User> listFollowing(@RequestParam("userId") Integer uid1) {
		return userService.getFollowingList(uid1);
	}

	/*
	 * 
	 * Handles the request to read tweets for current user
	 * 
	 *  
	*/	
	@RequestMapping(value = "/readTweets", params = { "userId" })
	public @ResponseBody
	List<Tweet> readTweets(@RequestParam("userId") Integer uid1, ServletRequest request) {

		List<Tweet> t = userService.readTweets(uid1);

		return t;
	}

	/*
	 * 
	 * Handles the request to read specific tweets for current user
	 *  
	*/	
	@RequestMapping(value = "/readSpecificTweets", params = { "userId", "text" })
	@ResponseBody
	public List<Tweet> readSpecificTweets(@RequestParam("userId") Integer uid1,
			@RequestParam("text") String text) {
		return userService.readSpeicificTweets(text, uid1);
	}

}