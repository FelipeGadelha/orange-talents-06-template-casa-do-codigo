package br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
