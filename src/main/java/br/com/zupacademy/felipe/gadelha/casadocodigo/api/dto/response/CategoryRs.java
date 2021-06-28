package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response;

import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Category;

public class CategoryRs {

	private Long id;
	private String name;
	
	public CategoryRs(Category category) {
		this.id = category.getId();
		this.name = category.getName();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
