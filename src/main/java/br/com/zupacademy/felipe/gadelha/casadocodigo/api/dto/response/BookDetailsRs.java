package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Book;

public class BookDetailsRs {

	private Long id;
	private String title;
	private String isbn;
	private String resume;
	private Integer numberPages;
	private BigDecimal price;
	private LocalDate publishDate;
	private CategoryRs categoryRs;
	private AuthorDetailsRs authorDetailsRs;

	public BookDetailsRs(Book book) {
		id = book.getId();
		title = book.getTitle();
		isbn = book.getIsbn();
		resume = book.getResume();
		numberPages = book.getNumberPages();
		price = book.getPrice();
		publishDate = book.getPublishDate();
		categoryRs = new CategoryRs(book.getCategory());
		authorDetailsRs = new AuthorDetailsRs(book.getAuthor());
	}
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getResume() {
		return resume;
	}
	public Integer getNumberPages() {
		return numberPages;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public CategoryRs getCategoryRs() {
		return categoryRs;
	}
	public AuthorDetailsRs getAuthorDetailsRs() {
		return authorDetailsRs;
	}
}
