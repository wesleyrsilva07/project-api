package com.projetofinal.controller.form;

import com.projetofinal.modelo.Product;
import com.projetofinal.repository.ProductRepository;

public class UpdateProductForm {
	private String description;
	private String name;
	private Double price;

	public Product atualizar(Long id, ProductRepository produtoRepository) {
		Product produto = produtoRepository.getReferenceById(id);
		produto.setDescription(this.description);
		produto.setName(this.name);
		produto.setPrice(this.price);
		return produto;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
