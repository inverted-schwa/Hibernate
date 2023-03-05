package deptStore.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import deptStore.entities.Product;
import deptStore.entities.User;
import oneToMany.Student;

public class UserDao {
	private SessionFactory fact;
	private Session sess;
	private Transaction tx;
	private User login;
	public UserDao() {
		fact=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Product.class).buildSessionFactory();
	}
	
	public void insertDummyData()
	{
		List<Product> productlist=new ArrayList<>();
		sess=fact.openSession();
		tx=sess.beginTransaction();
		User u= new User(1001, "Steven", "Steve@mail.com", "password", 0, false, null);
		
		Product p1=new Product(104, "Hat", 9.95, 2);
		Product p2=new Product(105, "Sunglasses", 19.95, 1);
		Product p3=new Product(106, "Gloves", 17.95, 1);
		
		
		productlist.add(p1);
		productlist.add(p2);
		productlist.add(p3);
		u.setItemList(productlist);
		sess.save(u);
		tx.commit();
		System.out.println("Data saved");
	}
	
	public void insert(int userid, String username, String emailId, String password, int superCoins, boolean isAdmin,
			List<Product> itemList) {
		List<Product> productlist=new ArrayList<>();
		sess=fact.openSession();
		tx=sess.beginTransaction();
		User u= new User(userid, username, emailId, password, superCoins, isAdmin, itemList);
		sess.save(u);
		tx.commit();
		System.out.println("Data saved");
	}
	
	public void checkLogin(String uname, String pass) {
		sess=fact.openSession();
		Query<User> query = sess.createQuery("from User");
		List<User> ulist=query.list();
		ulist.forEach(u->{
			if(uname.equals(u.getUsername())&&pass.equals(u.getPassword())) {
				this.login=u;
				System.out.println("Logged in as "+u.getUsername());
			}
		});
	}
}
