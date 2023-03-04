package deptStore.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import deptStore.entities.Product;

public class ProductDao {
	private SessionFactory fact;
	private Session sess;
	private Transaction tx;
	public ProductDao() {
		fact=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
	}
	
	public void insertDummyData()
	{
		sess=fact.openSession();
		tx=sess.beginTransaction();
		Product p=new Product(101, "Shoes", 14.95, 250);
		sess.save(p);
		Product p1=new Product(102, "Shirt", 16.95, 350);
		sess.save(p1);
		Product p2=new Product(103, "Pants", 22.95, 150);
		sess.save(p2);
		tx.commit();
		System.out.println("Data saved");
	}
	
	public void insert(int itemid, String name, double price, int quantity)
	{
		sess=fact.openSession();
		tx=sess.beginTransaction();
		Product p=new Product(itemid, name, price, quantity);
		sess.save(p);
		tx.commit();
		System.out.println("Data saved");
	}
}
