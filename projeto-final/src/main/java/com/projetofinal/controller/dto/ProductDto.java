package com.projetofinal.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.projetofinal.modelo.Product;

public class ProductDto {
	private String description;
	private Long id;
	private String name;
	private Double price;
	
	public ProductDto(Product produto) {
		this.description = produto.getDescription();
		this.id = produto.getId();
		this.name = produto.getName();
		this.price = produto.getPrice();
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Double getPrice() {
		return price;
	}
	
	public static List<ProductDto> converter(List<Product> produtos){
		return produtos.stream().map(ProductDto::new).collect(Collectors.toList());
	}
	
	public static Page<ProductDto> convert(Page<Product> produtos) {
		return produtos.map(ProductDto::new);
	}
}
