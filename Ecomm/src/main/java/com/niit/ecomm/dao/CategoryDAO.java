package com.niit.ecomm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ecomm.model.Category;
@Repository("categoryDAO")
public interface CategoryDAO 
{
public boolean addCategory(Category category);
public boolean deleteCategory(Category category);
public boolean updateCategory(Category category);
public List<Category> listCategories();
public Category getCategory(int categoryId);
}