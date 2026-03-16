package com.hexagonal.ArquiteturaHexagonal.core.user.service;

import com.hexagonal.ArquiteturaHexagonal.core.shared.passwordEncoder.PasswordEncoder;
import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.CreateUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.user.User;
import com.hexagonal.ArquiteturaHexagonal.core.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateUser implements IUserCase<CreateUserDto, User> {


    private final UserRepository repo;
    private final PasswordEncoder encode;

    public CreateUser(UserRepository repo, PasswordEncoder encode){
        this.repo = repo;
        this.encode = encode;
    }

    @Override
    public User executar(CreateUserDto dto) {

        User novoUser = new User();
        novoUser.setNome(dto.getNome());

        novoUser.setEmail(dto.getEmail());

        novoUser.setCpf(dto.getCpf());
        novoUser.setSenha(dto.getSenha());

        String cryptoPassword = encode.encode(dto.getSenha());
        novoUser.setSenha(cryptoPassword);

        return repo.salvar(novoUser);
    }


}
