package deptStore.entities;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UserTable")
public class User {
	
	public User(int userid, String username, String emailId, String password, int superCoins, boolean isAdmin,
			List<Product> itemList) {
		super();
		this.userid = userid;
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.superCoins = superCoins;
		this.isAdmin = isAdmin;
		this.itemList = itemList;
	}
	@Id
	@Column(name="userid")
	private int userid;
	@Column(name="username")
	private String username;
	@Column(name="email")
	private String emailId;
	@Column(name="password")
	private String password;
	@Column(name="superCoins")
	private int superCoins;
	@Column(name="isAdmin")
	private boolean isAdmin;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="itemid")
	private List<Product> itemList;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSuperCoins() {
		return superCoins;
	}
	public void setSuperCoins(String superCoins) {
		this.superCoins = superCoins;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public List<Product> getItemList() {
		return itemList;
	}
	public void setItemList(List<Product> itemList) {
		this.itemList = itemList;
	}
	
	
}
