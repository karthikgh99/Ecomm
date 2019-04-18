package com.niit.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ecomm.dao.UserDAO;
import com.niit.ecomm.model.Category;
import com.niit.ecomm.model.User;


@Controller
public class UserController 
{
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/signup")
	public String showUser(Model m)
	{
		List<User> listUser=userDAO.listUser();
		m.addAttribute("userlist",listUser);
		m.addAttribute("u",new User());
		m.addAttribute("signup",true);
		return "home";
	}
	
	
	
	@RequestMapping(value="/InsertUser",method=RequestMethod.POST)
	public String insertUser(@ModelAttribute("u")User u,Model m)
	{
		//User user=new User();
		//user.setName(Name);
		//user.setUseraddress(useradd);
		//user.setUserphoneno(phoneno);
		//user.setEmail(email);
		//user.setPassword(password);
		u.setEnabled(true);
		u.setRole("ROLE_USER");
		System.out.println(userDAO.addUser(u));
		
		List<User> listUser=userDAO.listUser();
		m.addAttribute("userlist",listUser);
		return "redirect:/login";
	}
	
	@RequestMapping(value="/deleteUser/{Email}")
	public String deleteUser(@PathVariable("Email")String email,Model m)
	{
		 
		User user=userDAO.getUser(email);
		userDAO.deleteUser(user);
		
		List<User> listUser=userDAO.listUser();
		m.addAttribute("userlist",listUser);
		
		return "User";
	}
	
	@RequestMapping(value="/admin/editUser/{Email}")
	public String updateUser(@PathVariable("Email")String email,Model m)
	{
		 
		User user=userDAO.getUser(email);
		userDAO.updateUser(user);
		
		List<User> listUser=userDAO.listUser();
		m.addAttribute("userlist",listUser);
		
		return "User";
	}

}
