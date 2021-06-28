package br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
