package br.edu.fag.catalogservice.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fag.catalogservice.repository.entity.ProdutoEntity;

@Repository
public interface ProdutoRepositoryJpa extends JpaRepository<ProdutoEntity, Integer> {

    List<ProdutoEntity> findByAtivo(Boolean ativo);
 
}
