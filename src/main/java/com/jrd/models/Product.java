package com.jrd.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name = "TB_PRODUCTS")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
	
   @NotEmpty(message = "Campo não pode estar vazio")	
   @NotBlank(message = "Campo não pode estar em branco")   
   @Size(min = 4, max = 255)
   private String name;
   

   @Min(value = 0)
   @Max(value = 1000)
   private Integer quantity;
   
   private BigDecimal price;
   
   private Date dateCreated;
    
   
public Product() { }

public Product(String name, Integer quantity, BigDecimal price ) {
	super();
	this.name = name;
	this.quantity = quantity;
	this.price = price;
} 


@PrePersist
public void onPrePersist() {
	if(this.dateCreated == null) {
		this.dateCreated = new Date();
	}
}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}
public Date getDateCreated() {
	return dateCreated;
}
public void setDateCreated(Date dateCreated) {
	this.dateCreated = dateCreated;
}

@Override
public String toString() {
	return "Product [name=" + name + ", quantity=" + quantity + ", price=" + price + ", dateCreated=" + dateCreated
			+ "]";
}


   
   
}
