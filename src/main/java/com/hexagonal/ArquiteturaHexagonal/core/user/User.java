package com.hexagonal.ArquiteturaHexagonal.core.user;

import com.hexagonal.ArquiteturaHexagonal.core.user.model.IUser;
import jakarta.persistence.*;


public class User implements IUser {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    public User(){}

    @Override
    public Long getId() {
        return 0L;
    }

    @Override
    public void setId(Long id) {

    }

    @Override
    public String getNome() {
        return "";
    }

    @Override
    public void setNome(String nome) {

    }

    @Override
    public String getCpf() {
        return "";
    }

    @Override
    public void setCpf(String cpf) {

    }

    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public String getSenha() {
        return "";
    }

    @Override
    public void setSenha(String senha) {

    }
}
