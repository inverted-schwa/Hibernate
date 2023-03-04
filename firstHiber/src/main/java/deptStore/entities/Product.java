package deptStore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Product {
	
	public Product(int productid, String productName, double sellingPrice, int availableQuantity) {
		this.productid = productid;
		this.productName = productName;
		this.sellingPrice = sellingPrice;
		this.availableQuantity = availableQuantity;
	}
	
	public Product() {
		
	}
	
	@Id
	@Column(name="productid")
	private int productid;
	@Column(name="productName")
	private String productName;
	@Column(name="price")
	private double sellingPrice;
	@Column(name="quantity")
	private int availableQuantity;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
}
