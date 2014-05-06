/**
 * 
 */
package com.tweet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
/*	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,
			BindingResult result) {

		userService.addUser(user);
		return "redirect:/users";

	}

	@RequestMapping(value = "/removeuser", method = RequestMethod.POST)
	public String removeUser(@ModelAttribute("user") Integer userid,
			BindingResult result) {

		userService.removeUser(userid);
		return "redirect:/users";

	}
*//*	public abstract List<User> getUsersList();

	public abstract void addUser(User user);

	public abstract void removeUser(Integer id);

	public abstract boolean followUser(Integer id);

	public abstract boolean unfollowUser(Integer id);

	public abstract List<User> getFollowersList();

	public abstract List<User> getFollowingList();
*/

}