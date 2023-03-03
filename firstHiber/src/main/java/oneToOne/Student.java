package oneToOne;

import javax.persistence.*;

@Entity
@Table(name="StudentRelation")
public class Student {
	@Id
	@Column(name="sid")
	private int studentid;
	@Column(name="studentname")
	private String studentname;
	@Column(name="score")
	private double score;
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
	public Address getAddobj() {
		return addobj;
	}
	public void setAddobj(Address addobj) {
		this.addobj = addobj;
	}
	@OneToOne(targetEntity=Address.class)
	private Address addobj;
}
