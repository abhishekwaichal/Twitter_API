/**
 * 
 */
package com.tweet.controller;

import java.util.List;

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
import com.tweet.service.UserService;
import com.tweet.domain.UserInfo;

/**
 * @author Abhishek
 * 
 */
@Controller
@SessionAttributes("sessionUser")
public class UserController {

	@Autowired
	UserService userService;

	HttpSession session ;
	@RequestMapping(value = "/login", params = { "userId", "password" })
	public ModelAndView UserEntry(@RequestParam(value = "userId") String uName,
			@RequestParam(value = "password") String pass,
			HttpServletRequest request, HttpServletResponse response) {

		User u = userService.getUser(uName);
		UserInfo ui = userService.getUserInfo(uName);
		
		ModelAndView mv2 = new ModelAndView("error");
		if(u==null || ui == null){
			mv2.addObject("msg","User not found");
			return mv2;
		}
		

		if (!ui.getPass().equals(pass) || !ui.getUsername().equals(uName)) {
			System.out.println("Invalid U/P !");
			mv2.addObject("msg","Invalid username and/or password !");
			return mv2;
		}

		session = request.getSession();
		session.setAttribute("UserName", ui.getUsername());

		ModelAndView mv = new ModelAndView("Menu");

		mv.addObject("userID", u.getUserid());
		mv.addObject("email", u.getEmail());
		mv.addObject("name", u.getName());
		mv.addObject("userName", u.getUsername());

		return mv;
	}

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

	@RequestMapping(value = "/listfollowers", params = { "userId" })
	@ResponseBody
	public List<User> listFollowers(@RequestParam("userId") Integer uid1) {
		return userService.getFollowersList(uid1);
	}

	@RequestMapping(value = "/listfollowing", params = { "userId" })
	@ResponseBody
	public List<User> listFollowing(@RequestParam("userId") Integer uid1) {
		return userService.getFollowingList(uid1);
	}

	@RequestMapping(value = "/readTweets", params = { "userId" })
	public @ResponseBody
	List<Tweet> readTweets(@RequestParam("userId") Integer uid1) {

		List<Tweet> t = userService.readTweets(uid1);

		return t;
	}

	@RequestMapping(value = "/readSpecificTweets", params = { "userId", "text" })
	@ResponseBody
	public List<Tweet> readSpecificTweets(@RequestParam("userId") Integer uid1,
			@RequestParam("text") String text) {
		return userService.readSpeicificTweets(text, uid1);
	}

}