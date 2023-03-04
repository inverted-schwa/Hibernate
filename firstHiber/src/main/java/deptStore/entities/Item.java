package deptStore.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="items")
public class Item {
	
	public Item(int itemid, String itemname, int category, double buyingPrice) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.category = category;
		this.buyingPrice = buyingPrice;
	}
	@Id
	@Column (name="itemid")
	private int itemid;
	@Column (name="itemname")
	private String itemname;
	@Column (name="category")
	private int category;
	@Column (name="buyingPrice")
	private double buyingPrice;
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
}
