package com.jrd.services;

import java.util.List;

import com.jrd.models.Product;

public interface ProductService {		 
	      public List<Product>findAll();
		  public Product findById(Long id);
		  public Product create(Product product);
		  public Product update(Long id, Product product);
		  public void delete(Long id);
	
}
