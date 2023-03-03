package mydemo.training.firstHiber.entities;
import javax.persistence.*;
@Entity 
@Table
public class Student {
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Id //student ID will be created as primary key
	@Column (name="SID")
	private int studentid;
	@Column(name="SName")
	private String studentname;
	@Column(name="Score")
	private double score;
}
