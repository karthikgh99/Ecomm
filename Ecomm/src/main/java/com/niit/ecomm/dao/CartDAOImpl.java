package com.niit.ecomm.dao;


	import java.util.List;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.query.Query;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

import com.niit.ecomm.model.Cart;
import com.niit.ecomm.model.Category;

	@Repository("cartDAO")
	@Transactional
	public class CartDAOImpl implements CartDAO
	{

		@Autowired
		SessionFactory sessionFactory;
		
		@Override
		public boolean add(Cart cart) {
			try
			{
				sessionFactory.getCurrentSession().save(cart);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}

		@Override
		public boolean delete(Cart cart) {
			try
			{
				sessionFactory.getCurrentSession().delete(cart);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}

		@Override
		public boolean update(int cartId, int quantity)
		{
			try
			{
				sessionFactory.getCurrentSession();
				 Session session=sessionFactory.getCurrentSession();
				  Cart cart=(Cart)session.get(Cart.class, cartId);
				  cart.setQuantity(quantity);//updated quantity
				  cart.setTotalprice(quantity * cart.getProduct().getProductprice());
				  session.update(cart);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
 
		@Override
		public List<Cart> listcart(String uemail) {

			Session session=sessionFactory.openSession();
			Query query=session.createQuery(" from Cart where user.email='"+uemail+"' ");
			List<Cart> listCart=query.list();
			session.close();
			return listCart;
		}

		@Override
		public Cart getCart(int cartId) {
			Session session=sessionFactory.openSession();
			Cart cart=(Cart)session.get(Cart.class,cartId);
			session.close();
			return cart;
		}
		
	}

