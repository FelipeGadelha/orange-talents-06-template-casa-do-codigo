package br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Book;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.projection.BookProjection;

public interface BookRepository extends JpaRepository<Book, Long>{

	@Query(value = "SELECT b.id, b.title FROM book b", nativeQuery = true)
	List<BookProjection> findBooks();
	
}
