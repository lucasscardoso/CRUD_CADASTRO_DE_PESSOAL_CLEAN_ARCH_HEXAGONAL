package com.hexagonal.ArquiteturaHexagonal.core.user;

public enum USER_ROLE {

    ADMIN("Administrador"),
    CLIENTE("Cliente");

    private final String descricao;

    USER_ROLE(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
