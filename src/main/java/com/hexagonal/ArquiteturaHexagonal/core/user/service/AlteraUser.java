package com.hexagonal.ArquiteturaHexagonal.core.user.service;

import com.hexagonal.ArquiteturaHexagonal.core.shared.AlteraUserRequest;
import com.hexagonal.ArquiteturaHexagonal.core.shared.exception.UserNotFoundException;
import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.AlteraUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.user.User;
import com.hexagonal.ArquiteturaHexagonal.core.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AlteraUser implements IUserCase<AlteraUserRequest, AlteraUserDto> {

    private final UserRepository repo;
    public AlteraUser(UserRepository repo){
        this.repo = repo;
    }

    @Override
    public AlteraUserDto executar(AlteraUserRequest request) {
        User usuarioExistente = repo.buscar(request.id()).
                orElseThrow(() -> new UserNotFoundException("O id: " +  request.id() + ", não localizado em nossa base de dados"));


        usuarioExistente.setNome(request.dados().getNome());
        usuarioExistente.setEmail(request.dados().getEmail());

        User userAtualizado = repo.alterarUsuario(request.id(), usuarioExistente);

        return new AlteraUserDto(userAtualizado.getNome(),userAtualizado.getEmail());
    }


}
