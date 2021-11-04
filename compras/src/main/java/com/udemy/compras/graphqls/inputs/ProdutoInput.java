package com.udemy.compras.graphqls.inputs;

import lombok.Data;

@Data
public class ProdutoInput {
    private Long id;
    private String nome;
    private Float valor;
}
