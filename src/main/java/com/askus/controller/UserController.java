package com.askus.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.askus.model.User;
import com.askus.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	@Autowired(required=true)
    @Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	} 

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String confirmAskUs(@ModelAttribute("user") User u) {
		//u=new User();
		this.userService.addUser(u);
		return "redirect:/";
	}
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("user") User u,Model model,HttpServletRequest request) {
		//u=new User();
		String user_name=u.getUser_name();
		String user_password=u.getUser_password();
		List<User> list= this.userService.getUserByLogin(user_name, user_password);
		HttpSession session=request.getSession();
		if(list.size()>=0) {
			for(User user : list){
	            session.setAttribute("uname",user.getUser_name());
	        }
		}
		return "redirect:/";
	}
	@RequestMapping(value = "/user/add/ask", method = RequestMethod.POST)
	public String confirmAskUsFromQuestion(@ModelAttribute("user") User u) {
		//u=new User();
		this.userService.addUser(u);
		return "redirect:/question";
	}
	@RequestMapping(value = "/user/login/ask", method = RequestMethod.POST)
	public String checkLoginFromQuestion(@ModelAttribute("user") User u,Model model,HttpServletRequest request) {
		//u=new User();
		String user_name=u.getUser_name();
		String user_password=u.getUser_password();
		List<User> list= this.userService.getUserByLogin(user_name, user_password);
		HttpSession session=request.getSession();
		if(list.size()>=0) {
			for(User user : list){
	            session.setAttribute("uname",user.getUser_name());
	        }
		}
		return "redirect:/question";
	}
	
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public String showMembers(Model model){
		model.addAttribute("listuser", this.userService.listuser());		
		return "members";
		
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.getAttribute("uname")!=null)
			session.invalidate();
		return "redirect:/";
	}
	
}
