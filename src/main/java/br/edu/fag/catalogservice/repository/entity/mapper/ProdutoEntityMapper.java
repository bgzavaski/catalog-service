package br.edu.fag.catalogservice.repository.entity.mapper;

import br.edu.fag.catalogservice.repository.entity.ProdutoEntity;
import br.edu.fag.catalogservice.service.domain.ProdutoDomain;

public class ProdutoEntityMapper {

    public static ProdutoEntity toEntity(ProdutoDomain produtoDomain) {
        
        ProdutoEntity produtoEntity = new ProdutoEntity();

        produtoEntity.setNome(produtoDomain.getNome());
        produtoEntity.setDescricao(produtoDomain.getDescricao());
        produtoEntity.setPreco(produtoDomain.getPreco());
        produtoEntity.setCriadoEm(java.time.LocalDateTime.now());

        return produtoEntity;
    }

    public static ProdutoDomain toDomain(ProdutoEntity produtoEntity) {
        ProdutoDomain produtoDomain = new ProdutoDomain();

        produtoDomain.setNome(produtoEntity.getNome());
        produtoDomain.setDescricao(produtoEntity.getDescricao());
        produtoDomain.setPreco(produtoEntity.getPreco());

        return produtoDomain;
    }
}