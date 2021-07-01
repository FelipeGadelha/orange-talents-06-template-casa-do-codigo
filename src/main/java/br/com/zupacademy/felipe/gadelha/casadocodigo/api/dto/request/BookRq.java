package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Lob;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.annotation.UniqueValue;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Author;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Book;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Category;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.AuthorRepository;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.CategoryRepository;

public class BookRq {
	
	@NotNull @NotBlank 
	@UniqueValue(
			domainClass = Book.class,
			fieldName = "title",
			message = "Este Titulo já existe")
	private String title;
	@NotNull @NotBlank 
	@Length(max = 500)
	private String resume;
	@Lob
	private String sumary;
	@Positive @Min(20) 
	private BigDecimal price;
	@NotNull @Min(100)
	private Integer numberPages;
	@ISBN @NotNull @NotBlank
	@UniqueValue(
			domainClass = Book.class,
			fieldName = "isbn",
			message = "Este ISBN já existe")
	private String isbn;
	@Future
	private LocalDate publishDate;
	@NotNull 
	private Long categoryId;
	@NotNull
	private Long authorId;

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
	public Long getCategoryId() {
		return categoryId;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public Book convert(CategoryRepository categoryRepository, AuthorRepository authorRepository) {
		Optional<Category> optCategory = categoryRepository.findById(categoryId);
		Optional<Author> optAuthor = authorRepository.findById(authorId);
		Assert.state(optCategory.isPresent(), "Não existe categoria com este ID");
		Assert.state(optAuthor.isPresent(), "Não existe autor com este ID");
		return Book
				.builder()
				.title(title)
				.resume(resume)
				.sumary(sumary)
				.price(price)
				.numberPages(numberPages)
				.isbn(isbn)
				.publishDate(publishDate)
				.category(optCategory.get())
				.author(optAuthor.get())
				.build();
	}
}
