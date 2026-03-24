package com.hexagonal.ArquiteturaHexagonal.externals.entity;


import com.hexagonal.ArquiteturaHexagonal.core.user.entity.Endereco;
import jakarta.persistence.*;

@Entity
@Table(name = "enderecos")
public class AdressEntity {

    @Id
    private Long id;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String localidade;

    @Column(nullable = false)
    private String uf;

    @Column(nullable = false)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false,foreignKey = @ForeignKey(name = "fk_endereco_usuario"))
    private UserEntity usuario;


    public AdressEntity(){}

    public AdressEntity(Long id, String logradouro, String bairro, String localidade, String uf, String estado, UserEntity usuario) {
        this.id = id;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.estado = estado;
        this.usuario = usuario;
    }

    public static AdressEntity fromDomain(Endereco endereco) {
        AdressEntity entity = new AdressEntity();
        entity.setLogradouro(endereco.getLogradouro());
        entity.setBairro(endereco.getBairro());
        entity.setLocalidade(endereco.getLocalidade());
        entity.setUf(endereco.getUf());
        entity.setEstado(endereco.getEstado());
        return entity;
    }

    public Endereco toDomain() {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(this.logradouro);
        endereco.setBairro(this.bairro);
        endereco.setLocalidade(this.localidade);
        endereco.setUf(this.uf);
        endereco.setEstado(this.estado);
        return endereco;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
