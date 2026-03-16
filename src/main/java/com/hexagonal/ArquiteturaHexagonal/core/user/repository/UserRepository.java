package com.hexagonal.ArquiteturaHexagonal.core.user.repository;

import com.hexagonal.ArquiteturaHexagonal.core.user.User;

import java.util.Optional;

public interface UserRepository {
    User salvar(User user);
    Optional<User> buscar(String email);
}
