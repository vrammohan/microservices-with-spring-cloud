package com.microservices.productlist.loadbalancer;
/**
 * @author RammohanCHV
 * @purpose This class is the rest controller which will act as a producer of products. This is consumed by the customer service 
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.productlist.model.Product;

@RestController
public class ProductListController {

	List<Product> products=new ArrayList<Product>();

	@GetMapping("/products")
	public List<Product> getProducts(){
		
		for(int i=1;i<=5;i++) {
			Product p=new Product();
			p.setId(i*12345L);
			p.setProductBrand("Brand -"+i);
			p.setProductName("ProductName - "+i);
			p.setPrice(i*3.14);
			products.add(p);
		}
		return products;
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		
		Product p=products.get(id);
		return p;
	}
}
