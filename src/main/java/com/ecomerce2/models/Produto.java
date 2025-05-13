package com.ecomerce2.models;

import com.ecomerce2.dto.ProdutoDTO;
import com.ecomerce2.enums.Categoria;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;


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


    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

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
        this.categoria = produtoDTO.getCategoria();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(nome, produto.nome) && Objects.equals(descricao, produto.descricao) && Objects.equals(imagem, produto.imagem) && Objects.equals(preco, produto.preco) && categoria == produto.categoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, imagem, preco, categoria);
    }
}
