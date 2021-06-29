package br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
