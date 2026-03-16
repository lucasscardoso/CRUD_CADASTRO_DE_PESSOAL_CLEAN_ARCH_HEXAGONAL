package com.hexagonal.ArquiteturaHexagonal.core.shared.userDto;


public class BuscaUserDto {

    private String nome;
    private String email;
    private String cpf;


    public BuscaUserDto(){}
    public BuscaUserDto( String nome, String email, String cpf) {

        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
