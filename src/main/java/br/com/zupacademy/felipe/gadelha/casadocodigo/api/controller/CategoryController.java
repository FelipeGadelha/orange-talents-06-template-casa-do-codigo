package br.com.zupacademy.felipe.gadelha.casadocodigo.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request.CategoryRq;
import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response.CategoryRs;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryRepository categoryRepository;
	
	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoryRs> save(@RequestBody @Valid CategoryRq categoryRq, UriComponentsBuilder uriBuilder) {
		var category = categoryRepository.save(categoryRq.convert());
		var uri = uriBuilder
				.path("/categories/{id}")
				.buildAndExpand(category.getId())
				.toUri();
		return ResponseEntity.created(uri).body(new CategoryRs(category));
	}
	
	
}
