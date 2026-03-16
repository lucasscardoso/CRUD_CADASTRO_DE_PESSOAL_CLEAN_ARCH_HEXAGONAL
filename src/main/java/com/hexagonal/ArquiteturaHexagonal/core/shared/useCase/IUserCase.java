package com.hexagonal.ArquiteturaHexagonal.core.shared.useCase;

import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.AlteraUserDto;

public interface IUserCase <E,S> {
    S executar(E entrada);
}
