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
import com.niit.ecomm.dao.CategoryDAO;
import com.niit.ecomm.dao.OrderDetailsDAO;
import com.niit.ecomm.dao.ProductDAO;
import com.niit.ecomm.dao.UserDAO;
import com.niit.ecomm.model.Cart;
import com.niit.ecomm.model.Category;
import com.niit.ecomm.model.OrderDetails;
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
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	OrderDetailsDAO orderDetailsDAO;
	
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
		if(flag==1&&cart.getQuantity()<=cart.getProduct().getStock())
			cartDAO.update(cart.getCartId(), cart.getQuantity());
		else
		{
			Product product=productDAO.getProduct(pid);
			User u=userDAO.getUser(p.getName());
			cart.setProduct(product);
			cart.setQuantity(1);
			cart.setUser(u);
			cart.setTotalprice(product.getProductprice()*cart.getQuantity());
			if(cart.getQuantity()<=product.getStock())
			cartDAO.add(cart);
		}
		m.addAttribute("catlist",categoryDAO.listCategories());
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
		m.addAttribute("catlist",categoryDAO.listCategories());
		return "home";
	}
	
	@RequestMapping(value="/deleteCart/{cartId}")
	public String deleteCart(@PathVariable("cartId")int cartId,Model m)
	{
		m.addAttribute("catlist",categoryDAO.listCategories());
		Cart cart=cartDAO.getCart(cartId);
		cartDAO.delete(cart);
	
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/cart/updatecart")
	public String updateCart(@RequestParam("cartId")int cartId,@RequestParam("quantity") int quantity,Model m, Principal p)
	{
		Cart cart=cartDAO.getCart(cartId);
		System.out.println(cartId + " " + quantity);
		if(quantity<=cart.getProduct().getStock());
		cartDAO.update(cartId,quantity);
		
		//cartDAO.update(cart);
		
		List<Cart> listcart=cartDAO.listcart(p.getName());
		m.addAttribute("Cart",listcart);
		m.addAttribute("c",cart);
		m.addAttribute("catlist",categoryDAO.listCategories());
		return "redirect:/cart";
	}
	



@RequestMapping("/orders")
public String displayorderdetails(Model m,Principal p)
{
	List<OrderDetails> listorder=orderDetailsDAO.listOrders(p.getName());
	m.addAttribute("orderlist",listorder);
	
	m.addAttribute("ordersPage",true);
	
	return "home";
}
}