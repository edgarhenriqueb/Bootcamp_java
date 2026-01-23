package com.example.demo.controller;

import com.example.demo.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();
    private Long proximoId = 1L;

    // buscar /produtos em uma lista geral
    @GetMapping
    public List<Produto> listar() {
        return produtos;
    }

    // buscar pelo /produtos/utilizando o {id}
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // adicionar os /produtos
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        produto.setId(proximoId++);
        produtos.add(produto);
        return produto;
    }

    // remoção de /produtos por meio do /{id}
    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id) {
        boolean removido = produtos.removeIf(p -> p.getId().equals(id));
        return removido ? "Produto removido com sucesso" : "Produto não encontrado";
    }

    // Ação extra para validação de que a api está rodando
    @GetMapping("/hello")
    public String hello() {
        return "API inicial de Produtos está rodando com Spring Boot com sucesso";
    }
}
