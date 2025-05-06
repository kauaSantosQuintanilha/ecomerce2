package com.ecomerce2.models;

import com.ecomerce2.dto.ProdutoDTO;
import com.ecomerce2.enums.Categoria;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private Double preco;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;


    public Produto() {}
    public Produto(Long id, String nome, String descricao, String imagem, Double preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.preco = preco;
        this.categoria = categoria;
    }
    public Produto(ProdutoDTO produtoDTO) {
        this.id = produtoDTO.getId();
        this.nome = produtoDTO.getNome();
        this.descricao = produtoDTO.getDescricao();
        this.imagem = produtoDTO.getImagem();
        this.preco = produtoDTO.getPreco();
    }

}
