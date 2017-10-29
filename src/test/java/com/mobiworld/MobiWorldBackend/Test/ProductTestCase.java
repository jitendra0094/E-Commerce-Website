package com.mobiworld.MobiWorldBackend.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mobiworld.MobiWorldBackend.dao.ProductDAO;
import com.mobiworld.MobiWorldBackend.model.Product;

public class ProductTestCase {
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.mobiworld.MobiWorldBackend");
		
		context.refresh();
		
		// Inserting a Category Object.
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		
		//Insertion TestCase
		
		Product product=new Product();
		
		product.setProdname("Samsung j7");
		product.setProdDesc("This Mobile uses 3G technology.");
		product.setQuantity(27);
		product.setPrice(11000);
	

		productDAO.insertUpdateProduct(product);		
		System.out.println("Product Inserted");
		
		//Retrieval TestCase
	/*	
		Product product=productDAO.getProduct(2);
		System.out.println("Product Name:"+product.getProdname());
		System.out.println("Product Description:"+product.getProdDesc());
	*/	
	/*	//Deletion TestCase
		Product product=productDAO.getProduct(2);
		productDAO.deleteProduct(product);
		System.out.println("The Product Deleted");
	*/
		//Retrieving the Data
		
	/*	List<Product> list=productDAO.getProductDetails();
		
		for(Product product:list)
		{
			System.out.println(product.getProdid()+":"+product.getCatid()+":"+product.getSuppid()+":"+product.getProdname()+":"+product.getQuantity()+":"+product.getPrice()+":"+product.getProdDesc());
		}
	*/	
	/*	//Update the Product
		Product product=productDAO.getProduct(3);
		product.setProdname(" iphone 8");
		productDAO.insertUpdateProduct(product);
		System.out.println("The Product Updated");
	*/	
	}

}
