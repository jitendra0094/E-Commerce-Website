package com.mobiworld.MobiWorldBackend.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mobiworld.MobiWorldBackend.dao.CartDAO;
import com.mobiworld.MobiWorldBackend.model.Cart;

public class CartTestCase {

	public static void main(String[] args) {
	
AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.mobiworld.MobiWorldBackend");
		
		context.refresh();
		
		// Inserting a Cart Object.
		CartDAO cartDAO=(CartDAO)context.getBean("cartDAO");
		
	//Insertion TestCase
		
		Cart cart=new Cart();
		cart.setCartid(1001);
		cart.setProdid(1);
		cart.setProdname("Samsung OnNxt");
		cart.setPrice(16700);
		cart.setQuantity(10);
		cart.setStatus("N");
		cart.setUsername("jitendra");
		
		cartDAO.addToCart(cart);
		System.out.println("Added to the Cart");
		
	/*	//Deleting TestCase
		Cart cart=cartDAO.getCartItem(2);
		cartDAO.deleteCartItem(cart);
		System.out.println("The Cart Deleted");
	*/	
		//Displaying TestCase
	/*	
		List<Cart> list=cartDAO.getCartItems("Vineet");
		
		for(Cart cart:list)
		{
			System.out.println(cart.getCartid() +":::");
			System.out.println(cart.getProdid()+":::");
			System.out.println(cart.getProdname()+":::");
			System.out.println(cart.getPrice()+":::");
			System.out.println(cart.getQuantity()+":::");
		}
		
		System.out.println("Cart item Displayed:");
	*/	
		// Update TestCase
		
	/*	Cart cart=cartDAO.getCartItem(1);
		cart.setProdname("Samsung 8");
		cartDAO.updateCartItem(cart);
		System.out.println("The Cart Updated");
		*/
     }

	}


