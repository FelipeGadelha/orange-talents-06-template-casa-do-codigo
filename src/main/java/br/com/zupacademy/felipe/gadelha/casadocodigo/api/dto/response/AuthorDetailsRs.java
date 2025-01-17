package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response;

import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Author;

public class AuthorDetailsRs {

	private Long id;
	private String name;
	private String email;
	private String description;
	
	public AuthorDetailsRs(Author author) {
		this.id = author.getId();
		this.name = author.getName();
		this.email = author.getEmail();
		this.description = author.getDescription();
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
}
