package com.hexagonal.ArquiteturaHexagonal.externals.controllers;

import com.hexagonal.ArquiteturaHexagonal.core.shared.AlteraUserRequest;
import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.AlteraUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.user.service.AlteraUser;
import com.hexagonal.ArquiteturaHexagonal.externals.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class AlterarUserController {

    private final AlteraUser altearUserService;

    public AlterarUserController(AlteraUser altearUserService) {
        this.altearUserService = altearUserService;
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<AlteraUserDto> alteraUser(@PathVariable Long id, @RequestBody AlteraUserDto dto){

        AlteraUserRequest request = new AlteraUserRequest(id,dto);

        AlteraUserDto resultado = altearUserService.executar(request);

        return ResponseEntity.ok(resultado);
    }
}
