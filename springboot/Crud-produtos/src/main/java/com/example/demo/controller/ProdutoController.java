package com.example.demo.controller;

import com.example.demo.dto.ProdutoRequestDTO;
import com.example.demo.dto.ProdutoResponseDTO;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService serviceSemDesconto;
    private final ProdutoService serviceComDesconto;

    public ProdutoController(
            @Qualifier("produtoServiceImpl") ProdutoService serviceSemDesconto,
            @Qualifier("produtoServiceComDesconto") ProdutoService serviceComDesconto
    ) {
        this.serviceSemDesconto = serviceSemDesconto;
        this.serviceComDesconto = serviceComDesconto;
    }

    /**
     * Criar produto
     * - desconto=false → preço normal
     * - desconto=true  → preço com 10% de desconto
     */
    @PostMapping
    public ProdutoResponseDTO salvar(
            @RequestBody ProdutoRequestDTO dto,
            @RequestParam(defaultValue = "false") boolean desconto
    ) {
        return desconto
                ? serviceComDesconto.salvar(dto)
                : serviceSemDesconto.salvar(dto);
    }

    /**
     * Listar todos os produtos
     */
    @GetMapping
    public List<ProdutoResponseDTO> listar() {
        return serviceSemDesconto.listar();
    }

    /**
     * Buscar produto por ID
     */
    @GetMapping("/{id}")
    public ProdutoResponseDTO buscarPorId(@PathVariable Long id) {
        return serviceSemDesconto.buscarPorId(id);
    }

    /**
     * Atualizar produto
     * - desconto=false → atualiza sem desconto
     * - desconto=true  → atualiza com desconto
     */
    @PutMapping("/{id}")
    public ProdutoResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody ProdutoRequestDTO dto,
            @RequestParam(defaultValue = "false") boolean desconto
    ) {
        return desconto
                ? serviceComDesconto.atualizar(id, dto)
                : serviceSemDesconto.atualizar(id, dto);
    }

    /**
     * Remover produto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        serviceSemDesconto.remover(id);
        return ResponseEntity.ok("Produto com ID " + id + " deletado com sucesso.");
    
    }
}
