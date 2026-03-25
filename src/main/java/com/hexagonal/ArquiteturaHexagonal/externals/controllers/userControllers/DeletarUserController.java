package com.hexagonal.ArquiteturaHexagonal.externals.controllers.userControllers;

import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class DeletarUserController {

    private final IUserCase<Long, String> deletaUserService;

    public DeletarUserController(IUserCase<Long, String> deletaUserService) {
        this.deletaUserService = deletaUserService;
    }

    @DeleteMapping ("/deletar/{id}")
    public ResponseEntity<String> deletaUser(@PathVariable Long id){

        String userFindDto =  deletaUserService.executar(id);
        return ResponseEntity.ok(userFindDto);
    }
}
