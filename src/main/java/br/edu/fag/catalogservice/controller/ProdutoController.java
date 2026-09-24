package br.edu.fag.catalogservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fag.catalogservice.service.domain.ProdutoDomain;
import br.edu.fag.catalogservice.controller.dto.ProdutoDTO;
import br.edu.fag.catalogservice.controller.mapper.ProdutoDTOMapper;
import br.edu.fag.catalogservice.service.IProdutoService;
import br.edu.fag.catalogservice.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")    
public class ProdutoController {

    private final IProdutoService produtoService;

    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criar(@RequestBody ProdutoDTO produtoDTO) {
        
        ProdutoDomain produtoDomain = ProdutoDTOMapper.toDomain(produtoDTO);

        ProdutoDomain produtoCriado = produtoService.criarProduto(produtoDomain);
        
        ProdutoDTO resposta = ProdutoDTOMapper.toDto(produtoCriado);

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Integer id) { 
        ProdutoDomain produtoDevolvido = produtoService.buscarPorId(id);
        ProdutoDTO resposta = ProdutoDTOMapper.toDto(produtoDevolvido);

        return ResponseEntity.ok(resposta);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> buscarAtivos(@RequestParam(name = "ativo") Boolean ativo) {
        List<ProdutoDomain> produtosAtivos = produtoService.buscarAtivos(ativo);
        
        List<ProdutoDTO> produtosDto = new ArrayList<>();

        for (ProdutoDomain produtoDomain : produtosAtivos) {
            ProdutoDTO produtoDTO = ProdutoDTOMapper.toDto(produtoDomain);
            produtosDto.add(produtoDTO);
        }

        return ResponseEntity.ok(produtosDto);

    }

    @PostMapping("/{id}/deactivate")
    public ResponseEntity<ProdutoDTO> desativar(@PathVariable Integer id) {
        ProdutoDomain produtoDesativado = produtoService.buscarPorId(id);
        ProdutoDTO resposta = ProdutoDTOMapper.toDto(produtoDesativado);

        return ResponseEntity.ok(resposta);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> tratarErro(RuntimeException excecao) {
        
        return ResponseEntity
                .badRequest()
                .body(Map.of("erro", excecao.getMessage()));
    }
}