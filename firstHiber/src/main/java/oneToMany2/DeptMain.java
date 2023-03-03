package oneToMany2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import oneToMany.Student;
import oneToMany2.*;

public class DeptMain {
	private SessionFactory fact;
	private Session sess;
	private Transaction tx;
	public DeptMain() {
		fact=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Department.class).addAnnotatedClass(Employee.class).buildSessionFactory();
	}
	
	public void insert()
	{
		List<Employee> emplist=new ArrayList<>();
		sess=fact.openSession();
		tx=sess.beginTransaction();
		Department d=new Department();
		d.setDeptCode(2002);
		d.setDeptName("HR");
		d.setCity("Delhi");
		Employee e1=new Employee(101, d, "Jorden");
		Employee e2=new Employee(102, d, "Vansh");
		Employee e3=new Employee(103, d,"Anisha");
		
		emplist.add(e1);
		emplist.add(e2);
		emplist.add(e3);
		d.setEmp(emplist);
		sess.save(d);
		tx.commit();
		System.out.println("Data saved");
	}
	
	public void retrieveAllData() {
		sess=fact.openSession();
		Query<Student> query = sess.createQuery("from Student");
		List<Student> stulist=query.list();
		stulist.forEach(s->{
			System.out.println("Student name is "+s.getStudentname());
			System.out.println("Score is "+s.getScore());
		});
	}
	public static void main(String[] args) {
		DeptMain dmain=new DeptMain();
		dmain.insert();
	}
}
