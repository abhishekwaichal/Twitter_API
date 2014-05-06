/**
 * 
 */
package com.tweet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.tweet.service.UserService;

//import com.tweet.domain.User;
//import com.tweet.service.UserService;

/**
 * @author Abhishek
 * 
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET, params = {"userId", "password"})
	public ModelAndView firstTestMeth(@RequestParam(value = "userId") String uid, @RequestParam(value = "password") String pass) {

		ModelAndView mv = null;

		String userId =   uid;
		String password = pass;

		userService.testMeth();
		
		if((userId.equals("admin")) && (password.equals("password"))){
			mv = new ModelAndView("success");
			mv.addObject("userId",userId);
		}else{
			mv = new ModelAndView("error");
			mv.addObject("msg","Incorrect userId or password");
		}

		return mv;
	}

/*	
	@RequestMapping(value = "/followuser", method = RequestMethod.POST)
	public boolean followUser(@ModelAttribute("user") Integer uid1, @ModelAttribute("user1") Integer uid2) {
		return userService.followUser(uid1, uid2);
	}
	
	@RequestMapping(value = "/unfollowuser", method = RequestMethod.POST)
	public boolean unfollowUser(@ModelAttribute("user") Integer uid1, @ModelAttribute("user1") Integer uid2) {
		return userService.unfollowUser(uid1, uid2);
	}
	
	@RequestMapping(value = "/listfollowers", method = RequestMethod.POST)
	public List<User> listFollowers(@ModelAttribute("user") Integer uid1) {
		return userService.getFollowersList(uid1);
	}

	@RequestMapping(value = "/listfollowing", method = RequestMethod.POST)
	public List<User> listFollowing(@ModelAttribute("user") Integer uid1) {
		return userService.getFollowingList(uid1);
	}
	
	
*/
}