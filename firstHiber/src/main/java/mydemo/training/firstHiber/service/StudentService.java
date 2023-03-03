package mydemo.training.firstHiber.service;

import java.util.Scanner;

import mydemo.training.firstHiber.dao.StudentDao;
import mydemo.training.firstHiber.entities.Student;

public class StudentService {
	private Scanner sc;
	private StudentDao sdao;
	
	public StudentService() {
		sc= new Scanner(System.in);
		sdao = new StudentDao();
	}
	
	public void insertData()
	{
		System.out.println("Enter the number of students u want to accept");
		int nostu=sc.nextInt();
		for(int i=0;i<nostu;i++)
		{
			Student s=new Student();
			System.out.println("Enter Student id");
			s.setStudentid(sc.nextInt());
			System.out.println("Enter Student name ");
			s.setStudentname(sc.next());
			System.out.println("Enter Score ");
			s.setScore(sc.nextDouble());
			sdao.insert(s);
			
		}
	}
	public void deleteData()
	{
		System.out.println("Endter the Student ID which you want to delete");
		int id=sc.nextInt();
		sdao.delete(id);
	}
	
	public void updateData()
	{
		System.out.println("Enter Student id which u want to update");
		int studentid=sc.nextInt();
		sdao.update(studentid);
	}
	
	public void view()
	{
		sdao.retreiveAllDetails();
	}
	
	public void viewByName()
	{
		System.out.println("Enter name for which u want to retreive records");
		String name=sc.next();
		sdao.retrieveByName(name);
	}
	
	public void sortData() {
		sdao.sortData();
	}
	
	public void retrieveByScore() {
		sdao.retrieveByScore();
	}
}
