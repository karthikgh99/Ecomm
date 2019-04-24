package com.niit.ecomm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ecomm.model.Product;
@Repository("productDAO")
public interface ProductDAO 
{
public boolean addProduct(Product product);
public boolean deleteProduct(Product product);
public boolean updateProduct(Product product);
public List<Product> listProduct();
public List<Product> listcatproduct(int cid);
public Product getProduct(int productId);
}