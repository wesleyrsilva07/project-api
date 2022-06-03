package com.projetofinal.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;
import com.projetofinal.controller.dto.ProductDto;
import com.projetofinal.controller.form.ProductForm;
import com.projetofinal.controller.form.UpdateProductForm;
import com.projetofinal.modelo.Product;
import com.projetofinal.repository.ProductRepository;

@Service
public class ProductServiceImplements implements ProductService {

	@Autowired
	ProductRepository produtoRepository;

	public Page<ProductDto> list(Pageable paginacao) {	
		
		Page<Product> produtos = produtoRepository.findAll(paginacao);
		return ProductDto.convert(produtos);
	}

	public ResponseEntity<ProductDto> delete(@PathVariable Long id) {
		Optional<Product> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {
			produtoRepository.deleteById(id);
		}

		return ResponseEntity.ok(new ProductDto(produto.get()));
	}

	public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
		Optional<Product> produtos = produtoRepository.findById(id);
		return ResponseEntity.ok(new ProductDto(produtos.get()));
	}

	public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductForm form, UriComponentsBuilder uriBuilder) {
		Product produto = form.converter();
		Product save = produtoRepository.save(produto);

		URI uri = uriBuilder.path("/products/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDto(save));
	}

	public ResponseEntity<ProductDto> update(@PathVariable Long id, @Valid @RequestBody UpdateProductForm form) {
		Product produto = form.atualizar(id, produtoRepository);
		return ResponseEntity.ok(new ProductDto(produto));
	}

	public List<ProductDto> search(@RequestParam(required = false) Double maxPrice,
			@RequestParam(required = false) Double minPrice, @RequestParam(required = false) String q) {
		List<Product> product = produtoRepository.findByPrice(maxPrice, minPrice, q);
		return ProductDto.converter(product);
	}

}
