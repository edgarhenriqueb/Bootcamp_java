package com.example.demo.service.impl;

import com.example.demo.dto.ProdutoRequestDTO;
import com.example.demo.dto.ProdutoResponseDTO;
import com.example.demo.exception.ProdutoNotFoundException;
import com.example.demo.exception.ValorProdutoInvalidoException;
import com.example.demo.mapper.ProdutoMapper;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service("produtoServiceComDesconto")
public class ProdutoServiceComDescontoImpl implements ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoServiceComDescontoImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {
        BigDecimal precoFinal = validarAplicarDesconto(dto.getPreco());

        Produto produto = ProdutoMapper.toEntity(dto);
        produto.setPreco(precoFinal);

        Produto salvo = repository.save(produto);
        return ProdutoMapper.toDTO(salvo);
    }

    @Override
    public List<ProdutoResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(ProdutoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));
        return ProdutoMapper.toDTO(produto);
    }

    @Override
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        BigDecimal precoFinal = validarAplicarDesconto(dto.getPreco());

        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        produto.setNome(dto.getNome());
        produto.setPreco(precoFinal);

        Produto atualizado = repository.save(produto);
        return ProdutoMapper.toDTO(atualizado);
    }

    @Override
    public void remover(Long id) {
        if (!repository.existsById(id)) {
            throw new ProdutoNotFoundException(id);
        }
        repository.deleteById(id);
    }

    // 🔒 regra de negócio + desconto
    private BigDecimal validarAplicarDesconto(BigDecimal preco) {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValorProdutoInvalidoException(preco);
        }

        BigDecimal desconto = preco.multiply(BigDecimal.valueOf(0.9));

        return desconto.setScale(2, RoundingMode.HALF_UP);
    }
}
