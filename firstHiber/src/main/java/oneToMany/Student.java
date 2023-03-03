package oneToMany;

import javax.persistence.*;
@Entity
@Table(name="StudentoneTomany")
public class Student {
	@Id
	private int studentid;
	public Student(int studentid, String studentname, int score) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.score = score;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	private String studentname;
	private int score;
	public Student()
	{
		
	}
	@ManyToOne
	private College clgobj;

}
