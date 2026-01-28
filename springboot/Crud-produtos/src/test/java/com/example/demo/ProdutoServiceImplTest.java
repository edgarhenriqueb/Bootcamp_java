package com.example.demo;

import com.example.demo.dto.ProdutoRequestDTO;
import com.example.demo.dto.ProdutoResponseDTO;
import com.example.demo.exception.ValorProdutoInvalidoException;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.service.impl.ProdutoServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceImplTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoServiceImpl service;

    @Test
    void deveSalvarProdutoSemDesconto() {
        // Arrange (dado)
        ProdutoRequestDTO dto = new ProdutoRequestDTO();
        dto.setNome("Produto Teste");
        dto.setPreco(BigDecimal.valueOf(100));

        Produto produtoSalvo = new Produto();
        produtoSalvo.setId(1L);
        produtoSalvo.setNome("Produto Teste");
        produtoSalvo.setPreco(BigDecimal.valueOf(100.00));

        when(repository.save(any())).thenReturn(produtoSalvo);

        // Act (quando)
        ProdutoResponseDTO response = service.salvar(dto);

        // Assert (então)
        assertEquals(BigDecimal.valueOf(100.00), response.getPreco());
        assertEquals("Produto Teste", response.getNome());
    }

    @Test
    void deveLancarExcecaoQuandoPrecoInvalido() {
        ProdutoRequestDTO dto = new ProdutoRequestDTO();
        dto.setNome("Produto Inválido");
        dto.setPreco(BigDecimal.valueOf(-10));

        assertThrows(
                ValorProdutoInvalidoException.class,
                () -> service.salvar(dto)
        );
    }
}
