package com.hexagonal.ArquiteturaHexagonal.externals.controllers;

import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.BuscaUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.CreateUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class BuscarUserController {

    private final IUserCase<String, BuscaUserDto> buscaUserService;

    public BuscarUserController(IUserCase<String, BuscaUserDto> createUserService) {
        this.buscaUserService = createUserService;
    }

    @GetMapping("/buscar")
    public ResponseEntity<BuscaUserDto> createUser(@RequestParam String email){

        BuscaUserDto userFindDto =  buscaUserService.executar(email);
        return ResponseEntity.ok(userFindDto);
    }
}
