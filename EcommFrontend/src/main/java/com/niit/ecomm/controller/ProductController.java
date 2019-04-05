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

import com.niit.ecomm.dao.ProductDAO;
import com.niit.ecomm.model.Category;
import com.niit.ecomm.model.Product;


@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/product")
	public String showProduct(Model m)
	{
		List<Product> listProduct=productDAO.listProduct();
		m.addAttribute("product",listProduct);
		m.addAttribute("p",new Product());
		return "Product";
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("p") Product p,Model m)
	{
		//Product product=new Product();
		/*
		 * product.setProductname(productName); product.setProductdesc(productDesc);
		 * product.setProductprice(price);
		 */
		System.out.println(p.getProductid());
		Product p1=productDAO.getProduct(p.getProductid());
		
		if(p1!=null)
		{
			System.out.println(p1.getProductid());
			//p1.setProductname(p.getProductname());
			//p1.setProductdesc(p.getProductdesc());
			productDAO.updateProduct(p);
		}
		else
		productDAO.addProduct(p);
		
		List<Product> listProduct=productDAO.listProduct();
		m.addAttribute("product",listProduct);
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		 
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		List<Product> listProduct=productDAO.listProduct();
		m.addAttribute("product",listProduct);
		
		return "Product";
	}
	
	@RequestMapping(value="/editProduct-{productId}")
	public String updateProduct(@PathVariable("productId")int productId,Model m)
	{
		 
		Product product=productDAO.getProduct(productId);
		//productDAO.updateProduct(product);
		
		List<Product> listProduct=productDAO.listProduct();
		m.addAttribute("product",listProduct);
		m.addAttribute("p",product);
		return "Product";
	}
	
	
	
}
