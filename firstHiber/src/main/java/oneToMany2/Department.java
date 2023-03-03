package oneToMany2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table (name="DepartmentOneToMany")
public class Department {
	@Id
	@Column(name="deptcode")
	private int deptCode;
	@Column(name="deptname")
	private String deptName;
	@Column(name="city")
	private String city;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="deptcode")
	private List<Employee> emp= new ArrayList<Employee>();
	public int getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	
}
