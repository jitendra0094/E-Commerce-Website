package com.mobiworld.MobiWorldBackend.DBConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mobiworld.MobiWorldBackend.dao.CartDAO;
import com.mobiworld.MobiWorldBackend.dao.CategoryDAO;
import com.mobiworld.MobiWorldBackend.dao.ProductDAO;
import com.mobiworld.MobiWorldBackend.dao.SupplierDAO;
import com.mobiworld.MobiWorldBackend.dao.UserDAO;
import com.mobiworld.MobiWorldBackend.model.Cart;
import com.mobiworld.MobiWorldBackend.model.Category;
import com.mobiworld.MobiWorldBackend.model.Product;
import com.mobiworld.MobiWorldBackend.model.Supplier;
import com.mobiworld.MobiWorldBackend.model.User;


@Configuration
@ComponentScan("com.mobiworld.MobiWorldBackend")
@EnableTransactionManagement
public class DBConfig 
{

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() 
	{
		System.out.println("Starting of the method getH2DataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/MyDevDB");
		dataSource.setUsername("user");
		dataSource.setPassword("user");
		System.out.println("Data Source Creation");
		return dataSource;
	}

	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		System.out.println("---Hibernate Properties----");
		Properties prop=new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.show_sql", "true"); //optional
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		System.out.println("---Hibernate Properties Created");
		
		System.out.println("---Local SessionFactory Builder Object Creation---");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		sessionBuilder.addProperties(prop);
		System.out.println("---Factory Builder Object Created---");
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		System.out.println("Session Factory Object Creation");
		SessionFactory sessionFactory=sessionBuilder.buildSessionFactory();
		System.out.println("Session Factory Object Created");
		return sessionFactory;
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("--Transaction manager Object Creation--");
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		System.out.println("--Transaction manager Object Created--");
		return transactionManager;
	}
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	{
		System.out.println("-- CategoryDAO Object Creation--");
		return new CategoryDAO(sessionFactory);
	}
	

	@Autowired
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		System.out.println("-- SupplierDAO Object Creation--");
		return new SupplierDAO(sessionFactory);
	}
	
	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory)
	{
		System.out.println("-- ProductDAO Object Creation--");
		return new ProductDAO(sessionFactory);
	}
	
	@Autowired
	@Bean(name="userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		System.out.println("-- UserDAO Object Creation--");
		return new UserDAO(sessionFactory);
	}
	

	@Autowired
	@Bean(name="cartDAO")
	public CartDAO getCartDAO(SessionFactory sessionFactory)
	{
		System.out.println("-- CartDAO Object Creation--");
		return new CartDAO(sessionFactory);
}
}

