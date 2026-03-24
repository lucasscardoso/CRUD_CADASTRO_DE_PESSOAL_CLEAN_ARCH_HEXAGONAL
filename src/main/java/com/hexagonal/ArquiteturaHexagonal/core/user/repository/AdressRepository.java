package com.hexagonal.ArquiteturaHexagonal.core.user.repository;

import com.hexagonal.ArquiteturaHexagonal.core.shared.adressDto.ViaCepDTO;
import com.hexagonal.ArquiteturaHexagonal.core.user.entity.Endereco;
import com.hexagonal.ArquiteturaHexagonal.core.user.entity.User;

import java.util.Optional;

public interface AdressRepository {
    Endereco salvar(Endereco endereco);
    Optional<Endereco> buscarPorCep(String cep);
    User alterarEndereco(Long id, Endereco salvar);
}
