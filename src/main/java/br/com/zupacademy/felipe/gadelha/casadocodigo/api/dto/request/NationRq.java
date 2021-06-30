package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.UniqueValue;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Nation;

public class NationRq {
	
	@NotBlank
	@UniqueValue(
			domainClass = Nation.class,
			fieldName = "name")
	private String name;
	
	public String getName() {
		return name;
	}

	public Nation convert() {
		return new Nation(name);
	}
}
