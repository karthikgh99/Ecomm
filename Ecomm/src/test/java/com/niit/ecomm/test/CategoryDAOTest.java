package com.niit.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecomm.dao.CategoryDAO;
import com.niit.ecomm.model.Category;

public class CategoryDAOTest 
{
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("SamsungMobile");
		category.setCategoryDesc("All Smart Mobile of Samsung Brand");
		
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));
	}
}
	
