package com.niit.ecomm.controller;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.ecomm.dao.CategoryDAO;
import com.niit.ecomm.dao.ProductDAO;
import com.niit.ecomm.model.Category;
import com.niit.ecomm.model.Product;


@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/admin/product")
	public String showProduct(Model m)
	{
		List<Product> listProduct=productDAO.listProduct();
		m.addAttribute("product",listProduct);
		List<Category> listcategory=categoryDAO.listCategories();
		m.addAttribute("categories",listcategory);
		m.addAttribute("p",new Product());
		m.addAttribute("productpage",true);
		return "home";
	}
	
	
	@RequestMapping(value="/admin/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("p") Product p,Model m)
	{
	System.out.println("adding product");
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
		{
			 int cid=p.getCategory().getCategoryId();
		 Category cat=categoryDAO.getCategory(cid);
		 p.setCategory(cat);
		productDAO.addProduct(p);
		}
		
		int productId=p.getProductid();
		
		
		String path="D:\\eclipseprojects\\EcommFrontend\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(productId)+".jpg";
		File myImageFile=new File(path);
		
		if(!p.getImage().isEmpty())
		{
			try
			{
				byte buff[]=p.getImage().getBytes();
				FileOutputStream fos=new FileOutputStream(myImageFile);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				System.out.println("image is saved");
				bs.write(buff);
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("Error", "Error Occured during Image Uploading::"+e.getMessage());
			}
		}
		else
		{
			System.out.println("Error Occured While Uploading File");
			m.addAttribute("Error", "Error Occured during Image Uploading");
		}
		
		
		//End of Adding Image
		
		
	
		
		
		return "redirect:/admin/product";
	}
	
	@RequestMapping(value="/admin/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		 
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
	
		return "redirect:/admin/product";
	}
	
	@RequestMapping(value="admin/editProduct-{productId}")
	public String updateProduct(@PathVariable("productId")int productId,Model m)
	{
		 
		Product product=productDAO.getProduct(productId);
		//productDAO.updateProduct(product);
		
		List<Product> listProduct=productDAO.listProduct();
		m.addAttribute("product",listProduct);
		m.addAttribute("p",product);
		m.addAttribute("catlist",categoryDAO.listCategories());
		return "Product";
	}
	
	
	@RequestMapping(value="/filterproducts/{categoryId}")
	public String filterProduct(@PathVariable("categoryId")int categoryId,Model m)
	{
		 
		List<Product> catproducts=productDAO.listcatproduct(categoryId);
		m.addAttribute("plist",catproducts);
		m.addAttribute("homepage",true);
		m.addAttribute("catlist",categoryDAO.listCategories());
		return "home";
	}
	
}
