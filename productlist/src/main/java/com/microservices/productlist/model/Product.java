package com.microservices.productlist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString*/
public class Product {

	private Long id;
	private String productName;
	private String productBrand;
	private double price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product(Long id, String productName, String productBrand, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.productBrand = productBrand;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productBrand=" + productBrand + ", price="
				+ price + "]";
	} 
	
	
	
}
