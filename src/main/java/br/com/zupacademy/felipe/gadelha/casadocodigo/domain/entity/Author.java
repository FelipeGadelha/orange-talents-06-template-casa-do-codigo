package br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Size(max = 400)
	private String description;
	@CreationTimestamp
	@Column(name="creation_date", nullable = false)	
	private LocalDate creationDate;
	
	@Deprecated
	public Author() { }
	
	public Author(Builder builder) {
		this.name = builder.name;
		this.email = builder.email;
		this.description = builder.description;
	}
	
	public static Builder builder() {
        return new Builder();
	}
	
	public static class Builder {
		private String name;
		private String email;
		private String description;
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		public Author build() {
			return new Author(this);
		}
	}
	
	public Long getId() {
		return this.id;
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

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", email=" + email + ", description=" + description
				+ ", creationDate=" + creationDate + "]";
	}
}
