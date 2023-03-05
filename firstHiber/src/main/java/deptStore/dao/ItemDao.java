package deptStore.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import deptStore.entities.Item;

public class ItemDao {
	private SessionFactory fact;
	private Session sess;
	private Transaction tx;
	public ItemDao() {
		fact=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Item.class).buildSessionFactory();
	}
	
	public void insertDummyData()
	{
		List<Item> itemlist=new ArrayList<Item>();
		sess=fact.openSession();
		tx=sess.beginTransaction();
		Item i1=new Item(1001,"Sweatshirt",1 , 25.95);
		Item i2=new Item(1002,"Sweatpants",2 , 18.95);
		Item i3=new Item(1003,"Socks",3 ,6.95);
		
		itemlist.add(i1);
		itemlist.add(i2);
		itemlist.add(i3);
		
		sess.save(itemlist);
		tx.commit();
		System.out.println("Data saved");
	}
	
	public void insert(int itemid, String name, int category, double price) {
		sess=fact.openSession();
		tx=sess.beginTransaction();
		Item i = new Item(itemid, name, category, price);
		sess.save(i);
		tx.commit();
		System.out.println("Item saved");
	}
	
	public void update(int itemid, String name, double price) {
		
	}
	
	public void delete(int itemid){
		
	}
}
