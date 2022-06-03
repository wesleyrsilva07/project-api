package com.projetofinal.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projetofinal.controller.dto.ProductDto;
import com.projetofinal.controller.form.ProductForm;
import com.projetofinal.controller.form.UpdateProductForm;
import com.projetofinal.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public Page<ProductDto> list(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 3) Pageable paginacao) {

		return productService.list(paginacao);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
		return productService.findById(id);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductForm form, UriComponentsBuilder uriBuilder) {
		return productService.create(form, uriBuilder);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody UpdateProductForm form) {
		return productService.update(id, form);

	}

	@GetMapping("/search")
	@Transactional
	public Page<ProductDto> search(@RequestParam(required = false) Double maxPrice,
			@RequestParam(required = false) Double minPrice, @RequestParam(required = false) String q,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 3)
			Pageable paginacao) {
		return productService.search(maxPrice, minPrice, q, paginacao);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductDto> delete(@PathVariable Long id) {
		return productService.delete(id);
	}
}
