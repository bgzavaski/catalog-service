package br.edu.fag.catalogservice.service;

import java.util.List;

import br.edu.fag.catalogservice.service.domain.ProdutoDomain;

public interface IProdutoService {
    
    ProdutoDomain criarProduto(ProdutoDomain produtoDomain);

    ProdutoDomain buscarPorId(Integer id);

    List<ProdutoDomain> buscarAtivos(Boolean ativo);

    ProdutoDomain desativar(Integer id);
}
