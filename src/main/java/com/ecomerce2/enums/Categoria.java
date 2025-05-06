package com.ecomerce2.enums;

public enum Categoria {
    ELETRONICOS("Eletrônicos"),
    VESTUARIO("Vestuário"),
    ALIMENTOS("Alimentos"),
    BELEZA("Beleza"),
    MOVEIS("Móveis"),
    LIVROS("Livros"),
    BRINQUEDOS("Brinquedos");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
