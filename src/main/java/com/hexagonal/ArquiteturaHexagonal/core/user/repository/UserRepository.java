package com.hexagonal.ArquiteturaHexagonal.core.user.repository;

import com.hexagonal.ArquiteturaHexagonal.core.user.User;

import java.util.Optional;

public interface UserRepository {
    User salvar(User user);
    Optional<User> buscar(Long id);
    void deletar (Long id);
    User alterarUsuario(Long id, User novoUser);
}
