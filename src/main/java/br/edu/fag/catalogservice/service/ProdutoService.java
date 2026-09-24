package br.edu.fag.catalogservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import br.edu.fag.catalogservice.repository.IProdutoRepository;
import br.edu.fag.catalogservice.repository.ProdutoRepository;
import br.edu.fag.catalogservice.repository.entity.ProdutoEntity;
import br.edu.fag.catalogservice.repository.entity.mapper.ProdutoEntityMapper;
import br.edu.fag.catalogservice.service.domain.ProdutoDomain;
import br.edu.fag.catalogservice.service.ProductNotFoundException;

@Service
public class ProdutoService implements IProdutoService {

    private final IProdutoRepository produtoRepository;

    public ProdutoService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    
    @Override
    public ProdutoDomain criarProduto(ProdutoDomain produtoDomain) {
        
        produtoDomain.validarNomeProduto();
        produtoDomain.validarPrecoProduto();
        produtoDomain.validarDescricaoProduto();

        ProdutoEntity produtoEntity = ProdutoEntityMapper.toEntity(produtoDomain);
        ProdutoEntity produtoSalvo = produtoRepository.criar(produtoEntity);
        return ProdutoEntityMapper.toDomain(produtoSalvo);
    }

    @Override
    public ProdutoDomain buscarPorId(Integer id) {
        
        Optional<ProdutoEntity> produtoOptional = produtoRepository.buscarPorId(id);
        
        ProdutoEntity produtoEntity = produtoOptional.orElseThrow(
            () -> new ProductNotFoundException(id)
        );  
        
        return ProdutoEntityMapper.toDomain(produtoEntity);
    }

    @Override 
    public List<ProdutoDomain> buscarAtivos(Boolean ativo) {
        List<ProdutoEntity> produtosEntity = produtoRepository.buscarAtivos(ativo);

        List<ProdutoDomain> produtosDomain = new ArrayList<>();

        for (ProdutoEntity produtoEntity : produtosEntity) {
            ProdutoDomain produtoDomain = ProdutoEntityMapper.toDomain(produtoEntity);
            produtosDomain.add(produtoDomain);
        }
        return produtosDomain;
    }

    @Override 
    public ProdutoDomain desativar(Integer id) {
        Optional<ProdutoEntity> produtoOptional = produtoRepository.buscarPorId(id);
        
        ProdutoEntity produtoEntity = produtoOptional.orElseThrow(
            () -> new ProductNotFoundException(id)
        );
        
        produtoEntity.setAtivo(false);
        ProdutoEntity produtoDesativado = produtoRepository.desativar(produtoEntity);

        return ProdutoEntityMapper.toDomain(produtoDesativado);
                
    }
    
}          