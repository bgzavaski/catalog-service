package br.edu.fag.catalogservice.service;

import org.springframework.stereotype.Service;

import br.edu.fag.catalogservice.repository.ProdutoRepository;
import br.edu.fag.catalogservice.repository.entity.ProdutoEntity;
import br.edu.fag.catalogservice.repository.entity.mapper.ProdutoEntityMapper;
import br.edu.fag.catalogservice.service.domain.ProdutoDomain;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    
    public ProdutoDomain criarProduto(ProdutoDomain produtoDomain) {
        
        produtoDomain.validarNomeProduto();
        produtoDomain.validarPrecoProduto();
        produtoDomain.validarDescricaoProduto();

        ProdutoEntity produtoEntity = ProdutoEntityMapper.toEntity(produtoDomain);
        ProdutoEntity produtoSalvo = produtoRepository.criar(produtoEntity);
        return ProdutoEntityMapper.toDomain(produtoSalvo);
    } 
}          