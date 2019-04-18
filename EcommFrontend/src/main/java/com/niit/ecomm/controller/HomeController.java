package com.niit.ecomm.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ecomm.dao.ProductDAO;
import com.niit.ecomm.dao.UserDAO;
import com.niit.ecomm.model.Product;
import com.niit.ecomm.model.User;

@Controller
public class HomeController {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/login")
	public String showLogin(Model m,@RequestParam(value="error", required=false) String error,@RequestParam(value="logout",required=false) String logout)
	{
		if(error!=null)
			m.addAttribute("error","invalid username or password");
		if(logout!=null)
			m.addAttribute("logout","Logged out Successfully");
		m.addAttribute("loginPage",true);
		return "home";
		
	}
	
	
	
	@RequestMapping(value= {"/home","/"})
	public String showHome(Model m,Principal p,HttpSession session)
	{
		if(p!=null)
		{
		String email=p.getName();
		User u=userDAO.getUser(email);
		session.setAttribute("Username",u.getName());
		}
		m.addAttribute("plist",productDAO.listProduct());
		m.addAttribute("homepage",true);
		
		return "home";
	}
	@RequestMapping(value= {"/admin"})
	public String showadminHome(Model m)
	{
		m.addAttribute("adminPage",true);
		return "home";
	}
	
	@RequestMapping(value="/viewProduct/{productId}")
	public String showproductdetail(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		productDAO.updateProduct(product);
		
		m.addAttribute("viewproduct",true);
		m.addAttribute("p",product);
		
		return "home";
	}
		
		@RequestMapping(value="/payment/{productid}")
		public String showpayment(Model m,@PathVariable("productid")int productid)
		{
			m.addAttribute("payment",true);
			return "home";
		}
	}

