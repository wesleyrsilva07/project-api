package com.projetofinal.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import com.projetofinal.controller.dto.ProductDto;
import com.projetofinal.controller.form.ProductForm;
import com.projetofinal.controller.form.UpdateProductForm;

public interface ProductService {
	Page<ProductDto> list(Pageable paginacao);
	ResponseEntity<ProductDto> findById(Long id);
	ResponseEntity<ProductDto> create(ProductForm form, UriComponentsBuilder uriBuilder);
	ResponseEntity<ProductDto> update(Long id, UpdateProductForm form);
	ResponseEntity<ProductDto> delete(Long id);
	List<ProductDto> search(Double maxPrice, Double minPrice, String q);
}
