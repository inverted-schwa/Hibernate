package mydemo.training.firstHiber.dao;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import mydemo.training.firstHiber.entities.Student;

public class StudentDao {
	private SessionFactory fact;//a group of database connections
	private Session sess;//one database connection in a group
	private Transaction tx;
	private Scanner sc;
	
	public StudentDao()
	{
		fact =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		sess=fact.openSession();
	}
	
	public void insert(Student s)
	{
		sess=fact.openSession();
		tx=sess.beginTransaction();
		sess.save(s);
		System.out.println("Data saved");
	}
	
	public void delete(int studentid) {
		sess=fact.openSession();
		tx=sess.beginTransaction();
		Student s=sess.find(Student.class, studentid);
		if(s!=null)
		{
			sess.delete(s);
			tx.commit();
			System.out.println("data deleted");
		}
		else {
			System.out.println("Data not found");
		}
	}
	
	public void update(int sid) {
		sess=fact.openSession();
		tx=sess.beginTransaction();
		Student s1=sess.find(Student.class, sid);
		sc= new Scanner(System.in);
		if(s1!=null)
		{
			System.out.println("Enter new score which you want to update");
			int score=sc.nextInt();
			s1.setScore(score);
			sess.update(s1);
			tx.commit();
			System.out.println("Data updated");
		}
		else System.out.println("Data not updated");
	}
	
	public void retreiveAllDetails()
	{
		sess=fact.openSession();
		Query<Student> query=sess.createQuery("from Student");
		List<Student> studentlist=query.list();
		studentlist.forEach(s->
		{
			System.out.println("Student name is "+s.getStudentname());
			System.out.println("Score "+s.getScore());
		});
	}
	
	public void retrieveByName(String name) {
		sess=fact.openSession();
		Query<Student> query=sess.createQuery("from Student s where s.studentname=?1");
		query.setParameter(1, name);
		List<Student> slist=query.list();
		slist.forEach(s->{
			System.out.println("Student ID is "+s.getStudentid());
			System.out.println("Student name is "+s.getStudentname());
			//System.out.println("Student score is "+s.getScore());
		});
	}
	
	public void sortData()
	{
		sess=fact.openSession();
		Query<Student> query = sess.createQuery("from Student s order by s.score asc");
		List<Student> stulist=query.list();
		stulist.forEach(s->
		{
			System.out.println("Student name is "+s.getStudentname());
			System.out.println("Student score is "+s.getScore());
		});
	}
	
	public void retrieveByScore() {
		sess=fact.openSession();
		Query<Student> query = sess.createQuery("from Student s where s.studentname=?1 and s.score>50");
		query.setParameter(1, "Steven");
		List<Student> slist=query.list();
		slist.forEach(s->{
			System.out.println("Student name is "+s.getStudentname());
			System.out.println("Student score is " +s.getScore());
		});
	}
}
