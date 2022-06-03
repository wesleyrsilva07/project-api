package com.projetofinal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.projetofinal.controller.dto.ProductDto;
import com.projetofinal.controller.form.ProductForm;
import com.projetofinal.controller.form.UpdateProductForm;

public interface ProductService {
	List<ProductDto> list();
	ResponseEntity<ProductDto> findById(@PathVariable Long id);
	ResponseEntity<ProductDto> create(@RequestBody ProductForm form, UriComponentsBuilder uriBuilder);
	ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody UpdateProductForm form);
	ResponseEntity<ProductDto> delete(@PathVariable Long id);
	List<ProductDto> search(@RequestParam(required = false) Double maxPrice, @RequestParam(required = false) Double minPrice, @RequestParam(required = false) String q);
}
