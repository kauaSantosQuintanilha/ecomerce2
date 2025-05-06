package com.ecomerce2.dto;

import com.ecomerce2.models.Produto;
import lombok.Data;

@Data
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private Double preco;
    private String categoria;
    public ProdutoDTO() {
    }


}
