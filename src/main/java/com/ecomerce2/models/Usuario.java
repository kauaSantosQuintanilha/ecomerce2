package com.ecomerce2.models;

import com.ecomerce2.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String senha;
    private String email;

    public Usuario() {}
    public Usuario(String nome, String cpf, String senha, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
    }
    public Usuario(UsuarioDTO usuarioDTO) {
        this.id = usuarioDTO.getId();
        this.nome = usuarioDTO.getNome();
        this.cpf = usuarioDTO.getCpf();
        this.senha = usuarioDTO.getSenha();
        this.email = usuarioDTO.getEmail();
    }


}
