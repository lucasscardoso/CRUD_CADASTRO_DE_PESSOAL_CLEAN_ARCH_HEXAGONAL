package com.hexagonal.ArquiteturaHexagonal.core.shared.userDto;

import com.hexagonal.ArquiteturaHexagonal.core.user.USER_ROLE;

public class CreateUserDto {

    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private USER_ROLE role;


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
