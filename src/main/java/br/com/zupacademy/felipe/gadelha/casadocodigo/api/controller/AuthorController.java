package br.com.zupacademy.felipe.gadelha.casadocodigo.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request.AuthorRq;
import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response.AuthorRs;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	private final AuthorRepository authorRepository;
	
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AuthorRs> save(@RequestBody @Valid AuthorRq authorRq, UriComponentsBuilder uriBuilder) {
		var author = authorRepository.save(authorRq.convert());
		var uri = uriBuilder
				.path("/authors/{id}")
				.buildAndExpand(author.getId())
				.toUri();
		return ResponseEntity.created(uri).body(new AuthorRs(author));
	}
	
	
}
