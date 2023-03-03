package oneToMany2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeOneToMany")
public class Employee {
	@Id
	int employeeid;
	@ManyToOne
	private Department dept;
	String name;
	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public Department getDeptCode() {
		return dept;
	}
	public void setDeptCode(Department deptCode) {
		this.dept = deptCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee(int employeeid, Department deptCode, String name) {
		super();
		this.employeeid = employeeid;
		this.dept = deptCode;
		this.name = name;
	}
}
