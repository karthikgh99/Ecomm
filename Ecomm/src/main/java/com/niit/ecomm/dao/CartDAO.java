
package com.niit.ecomm.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ecomm.model.Cart;

@Repository("cartDAO")
public interface CartDAO 
	{
		public boolean add(Cart cart);
		public boolean delete(Cart cart);
		public boolean update(int cartId, int quantity);
		public List<Cart> listcart(String email);
		public Cart getCart(int cartId);
		
		}

	