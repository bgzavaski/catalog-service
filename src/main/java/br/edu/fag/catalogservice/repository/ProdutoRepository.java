package br.edu.fag.catalogservice.repository;

import org.springframework.stereotype.Repository;

import br.edu.fag.catalogservice.repository.entity.ProdutoEntity;

@Repository
public class ProdutoRepository {

    private final ProdutoRepositoryJpa produtoRepositoryJpa;

    public ProdutoRepository(ProdutoRepositoryJpa produtoRepositoryJpa) {
        this.produtoRepositoryJpa = produtoRepositoryJpa;    
    }

    public ProdutoEntity criar(ProdutoEntity produtoEntity) {
        return produtoRepositoryJpa.save(produtoEntity);
    }
}