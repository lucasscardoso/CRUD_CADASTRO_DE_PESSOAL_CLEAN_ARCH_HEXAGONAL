package com.hexagonal.ArquiteturaHexagonal.core.shared.userDto;


import com.hexagonal.ArquiteturaHexagonal.core.user.USER_ROLE;
import com.hexagonal.ArquiteturaHexagonal.core.user.User;

public class BuscaUserDto {

    private String nome;
    private String email;
    private String cpf;
    private USER_ROLE role;


    public BuscaUserDto(){}
    public BuscaUserDto( String nome, String email, String cpf, USER_ROLE role) {

        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.role = role;
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

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }

    public static BuscaUserDto fromDomain(User user) {
        return new BuscaUserDto(user.getNome(), user.getEmail(), user.getCpf(),user.getRole());
    }
}
