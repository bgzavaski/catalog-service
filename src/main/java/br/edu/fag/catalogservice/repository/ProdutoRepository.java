package br.edu.fag.catalogservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.edu.fag.catalogservice.repository.entity.ProdutoEntity;

@Repository
public class ProdutoRepository implements IProdutoRepository {

    private final ProdutoRepositoryJpa produtoRepositoryJpa;

    public ProdutoRepository(ProdutoRepositoryJpa produtoRepositoryJpa) {
        this.produtoRepositoryJpa = produtoRepositoryJpa;    
    }

    @Override
    public ProdutoEntity criar(ProdutoEntity produtoEntity) {
        return produtoRepositoryJpa.save(produtoEntity);
    }

    @Override
    public Optional<ProdutoEntity> buscarPorId(Integer id) {
        return produtoRepositoryJpa.findById(id);
    }

    @Override
    public List<ProdutoEntity> buscarAtivos(Boolean ativo) {
        
        return produtoRepositoryJpa.findByAtivo(ativo);
    }

    @Override 
    public ProdutoEntity desativar(ProdutoEntity produtoEntity) {
    
        return produtoRepositoryJpa.save(produtoEntity);
    }
}