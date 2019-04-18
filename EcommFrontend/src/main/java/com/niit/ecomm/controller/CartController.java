package com.niit.ecomm.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ecomm.dao.CartDAO;
import com.niit.ecomm.dao.ProductDAO;
import com.niit.ecomm.dao.UserDAO;
import com.niit.ecomm.model.Cart;
import com.niit.ecomm.model.Category;
import com.niit.ecomm.model.Product;
import com.niit.ecomm.model.User;

@Controller
public class CartController {

	@Autowired
	CartDAO cartDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping(value="/InsertCart/{pid}")
	public String insertCart(@PathVariable("pid") int pid,Model m,Principal p)
	{
	Cart cart=new Cart();
	//cart.setCartName(Name);
		//cart.setCartDesc(cartDesc);
	int flag=0;
		
		List<Cart> listCart=cartDAO.listcart(p.getName());
		for(Cart c:listCart)
		{
			Product prd=c.getProduct();
			if(pid==prd.getProductid())
			{
				flag=1;
				c.setQuantity(c.getQuantity()+1);
				c.setTotalprice(c.getProduct().getProductprice()*c.getQuantity());
				
				cart=c;
				//cartDAO.update(c);
				break;
			}
				
		}
		if(flag==1)
			cartDAO.update(cart.getCartId(), cart.getQuantity());
		else
		{
			Product product=productDAO.getProduct(pid);
			User u=userDAO.getUser(p.getName());
			cart.setProduct(product);
			cart.setQuantity(1);
			cart.setUser(u);
			cart.setTotalprice(product.getProductprice()*cart.getQuantity());
			cartDAO.add(cart);
		}
		
		return "redirect:/cart";
	}
	
	
	@RequestMapping("/cart")
	public String displaycart(Model m,Principal p)
	{
		List<Cart> listCart=cartDAO.listcart(p.getName());
		m.addAttribute("cartlist",listCart);
		int sum=0;
		for(Cart c:listCart)
		{
			sum=sum+c.getTotalprice();
		}
		m.addAttribute("GrantTotal",sum);
		m.addAttribute("cartPage",true);
		return "home";
	}
	
	@RequestMapping(value="/deleteCart/{cartId}")
	public String deleteCart(@PathVariable("cartId")int cartId,Model m)
	{
		 
		Cart cart=cartDAO.getCart(cartId);
		cartDAO.delete(cart);
	
		return "redirect:/Cart";
	}
	
	@RequestMapping(value="/cart/updatecart")
	public String updateCart(@RequestParam("cartId")int cartId,@RequestParam("quantity") int quantity,Model m, Principal p)
	{
		System.out.println(cartId + " " + quantity);
		cartDAO.update(cartId,quantity);
		Cart cart=cartDAO.getCart(cartId);
		//cartDAO.update(cart);
		
		List<Cart> listcart=cartDAO.listcart(p.getName());
		m.addAttribute("Cart",listcart);
		m.addAttribute("c",cart);
		return "redirect:/cart";
	}
	
}
