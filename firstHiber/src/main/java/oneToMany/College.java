package oneToMany;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="CollegeData")
public class College {
	public int getCollegecode() {
		return collegecode;
	}
	public void setCollegecode(int collegecode) {
		this.collegecode = collegecode;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Student> getStudentlist() {
		return studentlist;
	}
	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}
	@Id
	@Column(name="collegecode")
	private int collegecode;
	@Column(name="collegename")
	private String collegename;
	@Column(name="city")
	private String city;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Collegecode")
	private List<Student> studentlist;
}
