package com.ecomerce2.dto;
import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String senha;
    private String email;


    public UsuarioDTO() {
    }


}
