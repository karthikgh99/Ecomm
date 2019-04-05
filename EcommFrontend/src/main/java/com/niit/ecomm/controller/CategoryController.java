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

import com.niit.ecomm.dao.CategoryDAO;
import com.niit.ecomm.model.Category;
import com.niit.ecomm.model.Product;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/category")
	public String showCategory(Model m)
	{
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categories",listCategories);
		m.addAttribute("cat",new Category());
		return "Category";
	}
	
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String insertCategory(@ModelAttribute("cat") Category cat,Model m)
	{
//		Category category=new Category();
//		category.setCategoryName(categoryName);
//		category.setCategoryDesc(categoryDesc);
//		
		System.out.println(cat.getCategoryId());
		Category c=categoryDAO.getCategory(cat.getCategoryId());
		
		if(c!=null)
		{
			System.out.println(c.getCategoryId());
			c.setCategoryName(cat.getCategoryName());
			c.setCategoryDesc(cat.getCategoryDesc());
			categoryDAO.updateCategory(c);
		}
		else
		categoryDAO.addCategory(cat);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categories",listCategories);
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categories",listCategories);
		
		return "Category";
	}
	
	@RequestMapping(value="/editCategory-{categoryId}")
	public String updateCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		m.addAttribute("cat",category);
		//categoryDAO.updateCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categories",listCategories);
		
		return "Category";
	}
	
}
