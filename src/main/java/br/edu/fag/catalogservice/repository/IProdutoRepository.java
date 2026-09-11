package br.edu.fag.catalogservice.repository;

import br.edu.fag.catalogservice.repository.entity.ProdutoEntity;

public interface IProdutoRepository {
    
    ProdutoEntity criar(ProdutoEntity produtoEntity);
}
