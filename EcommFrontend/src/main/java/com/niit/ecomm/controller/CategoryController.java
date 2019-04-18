package com.niit.ecomm.controller;

import java.util.List;
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

import com.niit.ecomm.dao.CategoryDAO;
import com.niit.ecomm.model.Category;
import com.niit.ecomm.model.Product;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/admin/category")
	public String showCategory(Model m)
	{
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categories",listCategories);
		m.addAttribute("cat",new Category());
		m.addAttribute("categoryPage",true);
		return "home";
	}
	
	@RequestMapping(value="/admin/InsertCategory",method=RequestMethod.POST)
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
			//c.setCategoryName(cat.getCategoryName());
			//c.setCategoryDesc(cat.getCategoryDesc());
			categoryDAO.updateCategory(c);
		}
		else
		categoryDAO.addCategory(cat);
		
		
		
		return "redirect:/admin/category";
	}
	
	@RequestMapping(value="/admin/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		
		
		
		return "redirect:/admin/category";
	}
	
	@RequestMapping(value="/admin/editCategory/{categoryId}")
	public String updateCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		//categoryDAO.updateCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categories",listCategories);
		m.addAttribute("cat",category);
		return "Category";
	}
	
}
