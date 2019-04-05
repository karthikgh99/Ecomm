package com.niit.ecomm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ecomm.model.User;
@Repository("userDAO")
public interface UserDAO 
{
public boolean addUser(User user);
public boolean deleteUser(User user);
public boolean updateUser(User user);
public List<User> listUser();
public User getUser(String email);
}