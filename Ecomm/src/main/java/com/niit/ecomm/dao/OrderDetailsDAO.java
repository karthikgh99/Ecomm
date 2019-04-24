package com.niit.ecomm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ecomm.model.OrderDetails;



@Repository("orderDetailsDAO")
public interface OrderDetailsDAO {
	boolean addOrder(OrderDetails order);
	OrderDetails getOrder(int id);
	List<OrderDetails> listOrders(String email);

	

}
