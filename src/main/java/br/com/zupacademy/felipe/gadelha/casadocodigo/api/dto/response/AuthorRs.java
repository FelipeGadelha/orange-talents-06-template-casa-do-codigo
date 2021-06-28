package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response;

import java.time.LocalDate;

import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Author;

public class AuthorRs {

	private Long id;
	private String name;
	private String email;
	private String description;
	private LocalDate creationDate;
	
	public AuthorRs(Author author) {
		this.id = author.getId();
		this.name = author.getName();
		this.email = author.getEmail();
		this.description = author.getDescription();
		this.creationDate = author.getCreationDate();
	}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}
	
	public LocalDate getCreationDate() {
		return creationDate;
	}
}
