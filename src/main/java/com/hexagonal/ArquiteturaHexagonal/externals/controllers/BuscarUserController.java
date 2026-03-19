package com.hexagonal.ArquiteturaHexagonal.externals.controllers;

import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.BuscaUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.CreateUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class BuscarUserController {

    private final IUserCase<Long, BuscaUserDto> buscaUserService;

    public BuscarUserController(IUserCase<Long, BuscaUserDto> buscaUserService) {
        this.buscaUserService = buscaUserService;
    }

    @GetMapping("/buscar/{id}")
    @PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
    public ResponseEntity<BuscaUserDto> buscarUser(@PathVariable Long id){

        BuscaUserDto userFindDto =  buscaUserService.executar(id);
        return ResponseEntity.ok(userFindDto);
    }
}
