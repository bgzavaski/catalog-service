package br.edu.fag.catalogservice.service.domain;

import java.math.BigDecimal;

public class ProdutoDomain {
    private String nome;
    private String descricao;
    private BigDecimal preco;
    
    public void validarNomeProduto() {
        if (nome == null || nome.isBlank()) {
            throw new RuntimeException("É obrigatório inserir um nome para o produto!");
        }
        if (nome.length() < 3) {
            throw new RuntimeException("O nome do produto deve possuir ao menos 3 letras.");
        }
    }    
    
    public void validarPrecoProduto() {
        if (preco == null) {
            throw new RuntimeException("O produto deve ter um preço.");
        }
        if (preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("O produto deve custar mais de R$ 0,00.");
git        }
    }
    
    public void validarDescricaoProduto() {
        if (preco.compareTo(new BigDecimal("1000")) >= 0  && (descricao == null || descricao.isBlank())) {
            throw new RuntimeException("O produto é de alto valor. Deve conter uma descrição");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
