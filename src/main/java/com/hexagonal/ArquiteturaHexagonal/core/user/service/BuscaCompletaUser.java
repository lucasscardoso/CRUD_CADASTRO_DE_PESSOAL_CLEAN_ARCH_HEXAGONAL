package com.hexagonal.ArquiteturaHexagonal.core.user.service;

import com.hexagonal.ArquiteturaHexagonal.core.shared.records.UserFilterDto;
import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.BuscaUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.user.User;
import com.hexagonal.ArquiteturaHexagonal.core.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscaCompletaUser implements IUserCase<UserFilterDto, List<BuscaUserDto>> {

    private final UserRepository repo;
    public BuscaCompletaUser(UserRepository repo){
        this.repo = repo;
    }


    @Override
    public List<BuscaUserDto> executar(UserFilterDto entrada) {
        List<User> usuarios = repo.findAll();

//     return   usuarios.stream()
//                .map(user -> new BuscaUserDto(
//                        user.getNome(),
//                        user.getEmail(),
//                        user.getCpf(),
//                        user.getRole()
//                )).toList();

        return usuarios.stream().map(BuscaUserDto::fromDomain).toList();
    }

}
