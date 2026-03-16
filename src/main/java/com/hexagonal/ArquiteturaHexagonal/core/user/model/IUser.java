package com.hexagonal.ArquiteturaHexagonal.core.user.model;

public interface IUser {
    Long getId();
    void setId(Long id);

    String getNome();
    void setNome(String nome);

    String getCpf();
    void setCpf(String cpf);

    String getEmail();
    void setEmail(String email);

    String getSenha();
    void setSenha(String senha);
}
