package oneToOne;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class AppMain {
	private SessionFactory fact;
	private Session sess;
	private Transaction tx;
	public AppMain() {
		fact=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Address.class).buildSessionFactory();
	}
	
	public void insert() {
		sess=fact.openSession();
		tx=sess.beginTransaction();
		Address add=new Address();
		add.setAdressid(1);
		add.setCity("Chicago");
		add.setState("Illinois");
		Student s=new Student();
		s.setStudentid(101);
		s.setStudentname("John");
		s.setScore(90);
		s.setAddobj(add);
		sess.save(add);
		sess.save(s);
		tx.commit();
		System.out.println("Data inserted");
		
	}
	public static void main(String[] args) {
		AppMain am = new AppMain();
		am.insert();
	}
}
