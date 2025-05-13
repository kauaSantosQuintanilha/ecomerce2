package com.ecomerce2.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String cnpj;


    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produtos;

    public Admin() {}
    public Admin(Long id, String nome, String email, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.senha = senha;
    }
    public Admin(String nome, String email, String senha, String endereco, String cnpj) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }


}
