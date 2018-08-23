package com.microservices.productlist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

	private Long id;
	private String productName;
	private String productBrand;
	private double price; 
}
