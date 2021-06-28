package br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotBlank
	@Column(nullable = false, unique = true)
	private String name;
	
	@Deprecated
	public Category() { }
	
	public Category(Builder builder) {
		this.name = builder.name;
	}
	
	public static Builder builder() {
        return new Builder();
	}
	
	public static class Builder {
		private String name;
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Category build() {
			return new Category(this);
		}
	}
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
