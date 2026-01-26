package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    //função de listar todos os produtos
    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    // função de buscar produto por id
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    //função de adicionar produto
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    // função de atualizar o produto
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id,
                             @RequestBody Produto produtoAtualizado) {

        return repository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            return repository.save(produto);
        }).orElse(null);
    }

    // remover produto
    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Produto removido com sucesso";
        }
        return "Produto não encontrado";
    }

    // teste de funcionamento
    @GetMapping("/hello")
    public String hello() {
        return "API de Produtos com JPA rodando com sucesso";
    }
}
