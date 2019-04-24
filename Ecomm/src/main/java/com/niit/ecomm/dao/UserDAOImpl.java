package com.niit.ecomm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecomm.model.User;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) 
		{
		System.out.println("adding user");
			try
			{
				System.out.println("saving in db");
				System.out.println(user.getEmail());
				sessionFactory.getCurrentSession().save(user);
				return true;
			}
			catch(Exception e)
			{
		return false;
			}
		}

	@Override
	public boolean deleteUser(User user) 
		{
			try
			{
				sessionFactory.getCurrentSession().delete(user);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}

	@Override
	public boolean updateUser(User user) 
		{
			try
			{
				sessionFactory.getCurrentSession().update(user);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}

	@Override
	public List<User> listUser() 
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from User");
			List<User> listUser=query.list();
			session.close();
			return listUser;
		}

	@Override
	public User getUser(String Email) 
		{
			Session session=sessionFactory.openSession();
			User user=(User)session.get(User.class,Email);
			session.close();
			return user;
		}
		
	}
