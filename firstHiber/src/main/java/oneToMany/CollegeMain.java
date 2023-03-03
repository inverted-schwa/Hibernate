package oneToMany;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import oneToMany.College;
import oneToMany.Student;

public class CollegeMain {
	private SessionFactory fact;
	private Session sess;
	private Transaction tx;
	public CollegeMain() {
		fact=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(College.class).addAnnotatedClass(Student.class).buildSessionFactory();
	}
	
	public void insert()
	{
		List<Student> studentlist=new ArrayList<>();
		sess=fact.openSession();
		tx=sess.beginTransaction();
		College c=new College();
		c.setCollegecode(202);
		c.setCollegename("HR");
		c.setCity("Delhi");
		Student s1=new Student(21,"Jorden",90);
		Student s2=new Student(22,"Vansh",78);
		Student s3=new Student(23,"Anisha",87);
		
		studentlist.add(s1);
		studentlist.add(s2);
		studentlist.add(s3);
		c.setStudentlist(studentlist);
		sess.save(c);
		tx.commit();
		System.out.println("Data saved");
	}
	
	public void view() {
		
	}
	public static void main(String[] args) {
		CollegeMain cmain=new CollegeMain();
		//cmain.insert();
	}
}
