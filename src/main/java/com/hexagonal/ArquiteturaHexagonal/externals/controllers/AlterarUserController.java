package com.hexagonal.ArquiteturaHexagonal.externals.controllers;

import com.hexagonal.ArquiteturaHexagonal.core.shared.records.AlteraUserRequest;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.AlteraUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.user.service.AlteraUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class AlterarUserController {

    private final AlteraUser altearUserService;

    public AlterarUserController(AlteraUser altearUserService) {
        this.altearUserService = altearUserService;
    }

    @PutMapping("/alterar/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<AlteraUserDto> alteraUser(@PathVariable Long id, @RequestBody AlteraUserDto dto){

        AlteraUserRequest request = new AlteraUserRequest(id,dto);

        AlteraUserDto resultado = altearUserService.executar(request);

        return ResponseEntity.ok(resultado);
    }
}
