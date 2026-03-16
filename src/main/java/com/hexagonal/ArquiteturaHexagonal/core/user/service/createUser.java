package com.hexagonal.ArquiteturaHexagonal.core.user.service;

import com.hexagonal.ArquiteturaHexagonal.core.shared.passwordEncoder.PasswordEncoder;
import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.CreateUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.user.User;
import com.hexagonal.ArquiteturaHexagonal.core.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class createUser implements IUserCase<CreateUserDto, User> {


    private final UserRepository repo;
    private final PasswordEncoder encode;

    public createUser(UserRepository repo,PasswordEncoder encode){
        this.repo = repo;
        this.encode = encode;
    }

    @Override
    public User executar(CreateUserDto usuario) {
        User novoUser = new User();
        novoUser.setNome(usuario.getNome());
        novoUser.setEmail(usuario.getEmail());
        novoUser.setCpf(usuario.getCpf());
        novoUser.setSenha(usuario.getSenha());

        String cryptoPassword = encode.encode(usuario.getSenha());
        novoUser.setSenha(cryptoPassword);

        return repo.salvar(novoUser);
    }


}
