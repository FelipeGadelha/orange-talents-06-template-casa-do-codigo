package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.UniqueValue;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Category;

public class CategoryRq {
	
	@NotNull @NotBlank
	@UniqueValue(
			domainClass = Category.class, 
			fieldName = "name",
			message = "Esta categoria já existe")
	private String name;

	public String getName() {
		return name;
	}
	
	public Category convert() {
		return Category
				.builder()
				.name(name)
				.build();
	}
	
	

}
