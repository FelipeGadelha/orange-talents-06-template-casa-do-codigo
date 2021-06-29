package br.com.zupacademy.felipe.gadelha.casadocodigo.api.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request.BookRq;
import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response.BookRs;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.projection.BookProjection;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.AuthorRepository;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.BookRepository;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.CategoryRepository;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookRepository bookRepository;
	private final CategoryRepository categoryRepository;
	private final AuthorRepository authorRepository;
	
	public BookController(BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.categoryRepository = categoryRepository;
		this.authorRepository = authorRepository;
	}

	@GetMapping
	public ResponseEntity<List<BookProjection>> findBooks() {
		return ResponseEntity.ok(bookRepository.findBooks());
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<BookRs> save(@RequestBody @Valid BookRq bookRq, UriComponentsBuilder uriBuilder) {
		var book = bookRepository.save(bookRq.convert(categoryRepository, authorRepository));
		var uri = uriBuilder
				.path("/books/{id}")
				.buildAndExpand(book.getId())
				.toUri();
		return ResponseEntity.created(uri).body(new BookRs(book));
	}
}
