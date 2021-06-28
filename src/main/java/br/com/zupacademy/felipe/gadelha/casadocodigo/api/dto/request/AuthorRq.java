package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


import br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.UniqueValue;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Author;

public class AuthorRq {

	@NotNull @NotBlank
	private String name;
	
	@NotNull @NotBlank @Email 
	@UniqueValue(
			fieldName = "email", 
			domainClass = Author.class, 
			message = "Este endereço de email já existe")
	private String email;
	
	@Length(max = 400)
	private String description;
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getDescription() {
		return description;
	}
	public Author convert() {
		return Author
				.builder()
				.name(this.name)
				.email(this.email)
				.description(this.description)
				.build();
	}
	@Override
	public String toString() {
		return "AuthorRq [name=" + name + ", email=" + email + ", description=" + description + "]";
	}
}
