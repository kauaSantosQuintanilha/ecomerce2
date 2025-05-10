package com.ecomerce2.dto;
import com.ecomerce2.models.Usuario;
import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String senha;
    private String email;
    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.cpf = usuario.getCpf();
    }

    public UsuarioDTO() {
    }


}
