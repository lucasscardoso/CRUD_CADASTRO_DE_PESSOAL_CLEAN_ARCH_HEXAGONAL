package com.hexagonal.ArquiteturaHexagonal.core.user.service;

import com.hexagonal.ArquiteturaHexagonal.core.shared.adressDto.ViaCepDTO;
import com.hexagonal.ArquiteturaHexagonal.core.shared.exception.AdressNotFoundException;

import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;

import com.hexagonal.ArquiteturaHexagonal.core.user.entity.Endereco;

import com.hexagonal.ArquiteturaHexagonal.core.user.repository.AdressRepository;

import org.springframework.stereotype.Service;

@Service
public class BuscaAdress implements IUserCase<String, ViaCepDTO> {

    private final AdressRepository repo;
    public BuscaAdress(AdressRepository repo){
        this.repo = repo;
    }

    @Override
    public ViaCepDTO executar(String cep) {
        Endereco end = repo.buscarPorCep(cep).orElseThrow(
                () -> new AdressNotFoundException(String.format("O Cep: %s " + ", não localizado em nossa base de dados",cep)) );

        ViaCepDTO dto = new ViaCepDTO();
        dto.setLogradouro(end.getLogradouro());
        dto.setBairro(end.getBairro());
        dto.setLocalidade(end.getLocalidade());
        dto.setEstado(end.getEstado());
        dto.setUf(end.getUf());

        return dto;
    }
}
