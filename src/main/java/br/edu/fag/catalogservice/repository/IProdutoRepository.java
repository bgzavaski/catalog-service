package br.edu.fag.catalogservice.repository;

import java.util.List;
import java.util.Optional;

import br.edu.fag.catalogservice.repository.entity.ProdutoEntity;

public interface IProdutoRepository {
    
    ProdutoEntity criar(ProdutoEntity produtoEntity);

    Optional<ProdutoEntity> buscarPorId(Integer id);

    List<ProdutoEntity> buscarAtivos(Boolean ativo);

    ProdutoEntity desativar(ProdutoEntity produtoEntity);
}
