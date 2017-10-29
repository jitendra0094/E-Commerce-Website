package com.mobiworld.MobiWorldBackend.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mobiworld.MobiWorldBackend.dao.UserDAO;
import com.mobiworld.MobiWorldBackend.model.User;

public class UserTestCase {
     
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.mobiworld.MobiWorldBackend");
		
		context.refresh();
		
		// Inserting a User Object.
		UserDAO userDAO=(UserDAO)context.getBean("userDAO");
		
		//Insertion TestCase
		
		User user=new User();
		
		user.setUsername("vikash");
		user.setPassword("vikash");
		user.setCustname("saurabh");
		user.setRole("Guest");
		user.setEmail("vikash@gmail.com");
		user.setEnabled(true);
		user.setCustaddress("in shop");

		userDAO.insertUpdateUser(user);		
		System.out.println("Username Inserted");
		
		//Retrieval TestCase
	/*	
		User user=userDAO.getUser(1);
		System.out.println("User Name:"+user.getUsername());
		System.out.println("User Password:"+user.getPassword());
	*/	
	/*	//Deletion TestCase
		User user=userDAO.getUser(4);
		userDAO.deleteUser(user);
		System.out.println("The Username Deleted");
	*/
		//Retrieving the Data
		
		List<User> list=userDAO.getUserDetails();
	/*	
		for(User user:list)
		{
			System.out.println(user.getUserid()+":"+user.getUsername()+":"+user.getPassword());
		}
	*/	
		//Update the Category
	/*	User user=userDAO.getUser(3);
		user.setUsername("ayush");
		userDAO.insertUpdateUser(user);
		System.out.println("The Username Updated");
	*/	
	}
}