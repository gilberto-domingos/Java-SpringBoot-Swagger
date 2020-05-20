package com.jrd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrd.models.Product;
import com.jrd.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}	

	@Override
	public List<Product> findAll() {		
		return this.productRepository.findAll();
}

	@Override
	public Product findById(Long id) {
	  return this.productRepository.findById(id).get();
	}	

	@Override
	public Product create(Product product) {
	  return this.productRepository.save(product);
		
	}

	@Override
	public Product update(Long id, Product product) {
		Product productExists = this.productRepository.findById(id).get();
		
		if (productExists != null) {
			product.setId(productExists.getId());
			this.productRepository.save(product);
			return product;
		}
		
		return null;
	}

	@Override
	public void delete(Long id) {
		Product product = this.productRepository.findById(id).get();
		
		if (product != null) this.productRepository.delete(product);
	}
	

}
