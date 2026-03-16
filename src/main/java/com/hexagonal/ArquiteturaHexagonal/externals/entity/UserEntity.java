package com.hexagonal.ArquiteturaHexagonal.externals.entity;


import com.hexagonal.ArquiteturaHexagonal.core.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String senha;

    public UserEntity(){}

    public UserEntity(Long id, String nome, String email, String cpf, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

    public static UserEntity fromDomain(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setNome(user.getNome());
        entity.setEmail(user.getEmail());
        entity.setCpf(user.getCpf());
        entity.setSenha(user.getSenha());
        return entity;
    }

    public User toDomain() {
        User user = new User();
        user.setId(this.id);
        user.setNome(this.nome);
        user.setEmail(this.email);
        user.setCpf(this.cpf);
        user.setSenha(this.senha);
        return user;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
