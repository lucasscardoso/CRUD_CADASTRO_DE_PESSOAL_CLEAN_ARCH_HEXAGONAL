package com.hexagonal.ArquiteturaHexagonal.core.shared.userDto;


public class AlteraUserDto {

    private String nome;
    private String email;

    public AlteraUserDto(){}
    public AlteraUserDto(String nome, String email) {

        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
