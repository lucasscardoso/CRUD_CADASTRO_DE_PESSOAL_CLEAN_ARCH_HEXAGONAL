package com.hexagonal.ArquiteturaHexagonal.core.shared.useCase;

public interface IUserCase <E,S> {
    S executar(E entrada);
}
