package com.hexagonal.ArquiteturaHexagonal.core.shared;

import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.AlteraUserDto;

public record AlteraUserRequest(Long id, AlteraUserDto dados) {
}
