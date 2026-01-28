package com.example.demo.exception;

import java.math.BigDecimal;

public class ValorProdutoInvalidoException extends RuntimeException {

    public ValorProdutoInvalidoException(BigDecimal valor) {
        super("Valor do produto inválido: " + valor +
              ". O valor não pode ser nulo ou negativo.");
    }
}
