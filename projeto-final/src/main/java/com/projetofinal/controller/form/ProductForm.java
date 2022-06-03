package com.projetofinal.controller.form;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.projetofinal.modelo.Product;

public class ProductForm {
	@Length(min = 10)
	private String description;
	@NotNull @NotEmpty
	private String name;
	
	@NotNull @Positive
	private Double price;
	

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public Product converter() {
		return new Product(description, name, price);
	}

}
