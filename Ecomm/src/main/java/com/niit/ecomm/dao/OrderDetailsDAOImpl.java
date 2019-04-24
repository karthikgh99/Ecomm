package com.niit.ecomm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecomm.model.OrderDetails;

@Transactional
@Repository("orderDetailsDAO")
public class OrderDetailsDAOImpl implements OrderDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
		public OrderDetailsDAOImpl(){
			
		}
		public boolean addOrder(OrderDetails order) {
	       Session session= sessionFactory.getCurrentSession();
	       session.save(order);
	       return true;
		}
		public OrderDetails getOrder(int id) {
			Session session=sessionFactory.getCurrentSession();
			OrderDetails order=(OrderDetails)session.get(OrderDetails.class, id);
			
			return order;
		}
		@Override
		public List<OrderDetails> listOrders(String email) {
			
			    String s1="from OrderDetails where  user.email='"+email+"'";
				Query o=sessionFactory.getCurrentSession().createQuery(s1);
				List<OrderDetails> list=o.list();
				return list;
			
			
		}


}
