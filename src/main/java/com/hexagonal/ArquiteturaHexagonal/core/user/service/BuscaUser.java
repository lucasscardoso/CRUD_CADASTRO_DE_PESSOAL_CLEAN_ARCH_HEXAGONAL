package com.hexagonal.ArquiteturaHexagonal.core.user.service;

import com.hexagonal.ArquiteturaHexagonal.core.shared.exception.UserNotFoundException;
import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.BuscaUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.user.User;
import com.hexagonal.ArquiteturaHexagonal.core.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscaUser implements IUserCase<Long, BuscaUserDto> {

    private final UserRepository repo;
    public BuscaUser(UserRepository repo){
        this.repo = repo;
    }

    @Override
    public BuscaUserDto executar(Long id) {
        User usuario =  repo.buscar(id).
                orElseThrow(() -> new UserNotFoundException(String.format("O email: %s " + ", não localizado em nossa base de dados",id)));

        BuscaUserDto dto = new BuscaUserDto();
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setCpf(usuario.getCpf());
        dto.setRole(usuario.getRole());

        return dto;
    }
}
