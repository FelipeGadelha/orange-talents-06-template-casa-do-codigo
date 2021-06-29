package br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotBlank 
	@Column(nullable = false, unique = true)
	private String title;
	@NotNull @NotBlank 
	@Column(nullable = false)
	@Size(max = 500)
	private String resume;
	@Lob
	private String sumary;
	@DecimalMin("20")
	@Positive 
	private BigDecimal price;
	@NotNull @Min(100)
	@Column(nullable = false)
	private Integer numberPages;
	@ISBN @NotNull @NotBlank 
	@Column(nullable = false, unique = true)
	private String isbn;
	@Future
	private LocalDate publishDate;
	
	@NotNull
	@ManyToOne
	private Category category;
	@NotNull
	@ManyToOne
	private Author author;
	
	@Deprecated
	public Book() {	}
	
	public Book(Builder builder) {
		this.title = builder.title;
		this.resume = builder.resume;
		this.sumary = builder.sumary;
		this.price = builder.price;
		this.numberPages = builder.numberPages;
		this.isbn = builder.isbn;
		this.publishDate = builder.publishDate;
		this.category = builder.category;
		this.author = builder.author;
	}
	public static Builder builder() {
        return new Builder();
	}
	public static class Builder {
		private String title;
		private String resume;
		private String sumary;
		private BigDecimal price;
		private Integer numberPages;
		private String isbn;
		private LocalDate publishDate;
		private Category category;
		private Author author;
		
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		public Builder resume(String resume) {
			this.resume = resume;
			return this;
		}
		public Builder sumary(String sumary) {
			this.sumary = sumary;
			return this;
		}
		public Builder price(BigDecimal price) {
			this.price = price;
			return this;
		}
		public Builder numberPages(Integer numberPages) {
			this.numberPages = numberPages;
			return this;
		}
		public Builder isbn(String isbn) {
			this.isbn = isbn;
			return this;
		}
		public Builder publishDate(LocalDate publishDate) {
			this.publishDate = publishDate;
			return this;
		}
		public Builder category(Category category) {
			this.category = category;
			return this;
		}
		public Builder author(Author author) {
			this.author = author;
			return this;
		}
		public Book build() {
			return new Book(this);
		}
	}
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getResume() {
		return resume;
	}
	public String getSumary() {
		return sumary;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public Integer getNumberPages() {
		return numberPages;
	}
	public String getIsbn() {
		return isbn;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public Category getCategory() {
		return category;
	}
	public Author getAuthor() {
		return author;
	}
}
