package com.hexagonal.ArquiteturaHexagonal.core.user.entity;

import com.hexagonal.ArquiteturaHexagonal.core.user.enums.USER_ROLE;
import com.hexagonal.ArquiteturaHexagonal.externals.entity.AdressEntity;

import java.util.List;


public class User {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private List<Endereco> enderecos;
    private USER_ROLE role;

    public User(){}

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }
}
