package com.hexagonal.ArquiteturaHexagonal.externals.controllers;

import com.hexagonal.ArquiteturaHexagonal.core.shared.records.UserFilterDto;
import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.BuscaUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class BuscarCompletaUserController {

    private final IUserCase<UserFilterDto, List<BuscaUserDto>> buscaCompletaService;

    public BuscarCompletaUserController(IUserCase<UserFilterDto, List<BuscaUserDto>> buscaCompletaService) {
        this.buscaCompletaService = buscaCompletaService;
    }

    @GetMapping("/buscartodos")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<BuscaUserDto>> buscarCompletaUsers(){

       List<BuscaUserDto> users = buscaCompletaService.executar(new UserFilterDto());
        return ResponseEntity.ok(users);
    }
}
