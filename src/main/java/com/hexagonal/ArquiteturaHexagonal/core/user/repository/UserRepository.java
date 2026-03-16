package com.hexagonal.ArquiteturaHexagonal.core.user.repository;

import com.hexagonal.ArquiteturaHexagonal.core.user.User;

public interface UserRepository {
    User salvar(User user);
}
