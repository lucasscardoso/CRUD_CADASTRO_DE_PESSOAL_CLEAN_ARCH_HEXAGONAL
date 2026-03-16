package com.hexagonal.ArquiteturaHexagonal.core.user.service;

import com.hexagonal.ArquiteturaHexagonal.core.shared.exception.UserNotFoundException;
import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.BuscaUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.user.User;
import com.hexagonal.ArquiteturaHexagonal.core.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscaUser implements IUserCase<String, BuscaUserDto> {

    private final UserRepository repo;
    public BuscaUser(UserRepository repo){
        this.repo = repo;
    }

    @Override
    public BuscaUserDto executar(String email) {
        User usuario =  repo.buscar(email).
                orElseThrow(() -> new UserNotFoundException(String.format("O email: %s " + ", não localizado em nossa base de dados",email)));

        BuscaUserDto dto = new BuscaUserDto();
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setCpf(usuario.getCpf());

        return dto;
    }
}
