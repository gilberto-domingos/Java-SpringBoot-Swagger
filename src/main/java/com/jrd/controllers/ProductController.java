package com.jrd.controllers;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jrd.models.Product;
import com.jrd.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "API Rest - Model Product")
@RestController
@RequestMapping("/produtos")
public class ProductController {
	
	private ProductService productService;	
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	
	
	@ApiOperation(value = "Lista todos os produtos do Banco de Dados")
	@GetMapping(produces = "application/json")	
	@ResponseBody
	public ResponseEntity<?> findAll(){
		List<Product>list = productService.findAll();
		
		return new ResponseEntity<List>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Lista um único produto do Banco de Dados pela ID")	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
		Product product = this.productService.findById(id);
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Cria novo produto no Banco de Dados")		
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Product product, Errors errors) {	
		
		if(!errors.hasErrors()) {
			Product productCreated = this.productService.create(product);
			
			return new ResponseEntity<Product>(productCreated, HttpStatus.CREATED);
		}		
		
		return ResponseEntity.badRequest().body(errors.getAllErrors()
				.stream()
		        .map(msg -> msg.getDefaultMessage())
		        .collect(Collectors.joining(","))); 
	}
	
	@ApiOperation(value = "Atualiza um produto no Banco de Dados")
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id")Long id, @Valid @RequestBody Product product, Errors errors){
		
		if(!errors.hasErrors()) {
			Product productUpdated = this.productService.update(id, product);
			
			return new ResponseEntity<Product>(productUpdated, HttpStatus.OK);
		}
		
		return ResponseEntity.badRequest().body(errors.getAllErrors()
				.stream()
		        .map(msg -> msg.getDefaultMessage())
		        .collect(Collectors.joining(","))); 		
		
	}
	
	
	@ApiOperation(value = "Deleta um produto do Banco de Dados")
	@DeleteMapping(value =  "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id")Long id) {
		this.productService.delete(id);
		
	}
	
	
	

}


















