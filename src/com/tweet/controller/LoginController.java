package com.tweet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView mv = null;
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		if((userId.equals("admin")) && (password.equals("password"))){
			mv = new ModelAndView("success");
			mv.addObject("userId",userId);
		}else{
			mv = new ModelAndView("error");
			mv.addObject("msg","Incorrect userId or password");
		}
		return mv;
	}

}
