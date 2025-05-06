package com.ecomerce2.dto;

import java.util.Objects;

public class AdminDTO {
    private Long id;
    private String nome;
    private String email;
    private String cnpj;
    public AdminDTO() {
    }
    public AdminDTO(Long id, String nome, String email, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AdminDTO adminDTO = (AdminDTO) o;
        return Objects.equals(id, adminDTO.id) && Objects.equals(nome, adminDTO.nome) && Objects.equals(email, adminDTO.email) && Objects.equals(cnpj, adminDTO.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, cnpj);
    }
}
