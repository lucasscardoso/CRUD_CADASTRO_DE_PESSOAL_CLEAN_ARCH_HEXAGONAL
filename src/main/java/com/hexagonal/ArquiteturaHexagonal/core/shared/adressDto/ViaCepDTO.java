package com.hexagonal.ArquiteturaHexagonal.core.shared.adressDto;

import com.hexagonal.ArquiteturaHexagonal.core.shared.exception.AdressNotFoundException;
import com.hexagonal.ArquiteturaHexagonal.core.user.entity.Endereco;

public class ViaCepDTO {

    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;

    public ViaCepDTO(){}

    public ViaCepDTO(String logradouro, String estado, String localidade, String bairro, String uf) {
        this.logradouro = logradouro;
        this.estado = estado;
        this.localidade = localidade;
        this.bairro = bairro;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
