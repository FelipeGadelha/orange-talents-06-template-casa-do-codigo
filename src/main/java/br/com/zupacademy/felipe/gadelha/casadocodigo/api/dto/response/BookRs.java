package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Book;

public class BookRs {

	private Long id;
	private String title;
	private String resume;
	private String sumary;
	private Integer numberPages;
	private BigDecimal price;
	private String isbn;
	private LocalDate publishDate;
	private Long categoryId;
	private Long authorId;

	public BookRs(Book book) {
		id = book.getId();
		title = book.getTitle();
		resume = book.getResume();
		sumary = book.getSumary();
		numberPages = book.getNumberPages();
		price = book.getPrice();
		isbn = book.getIsbn();
		publishDate = book.getPublishDate();
		categoryId = book.getCategory().getId();
		authorId = book.getAuthor().getId();
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
	public Integer getNumberPages() {
		return numberPages;
	}
	public BigDecimal getPrice() {
		return price;
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
}
