package com.hexagonal.ArquiteturaHexagonal.externals.controllers;

import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.CreateUserDto;
import com.hexagonal.ArquiteturaHexagonal.core.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class CreateUserController {

    private final IUserCase<CreateUserDto, User> createUserService;

    public CreateUserController(IUserCase<CreateUserDto, User> createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping("/criar")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto dto){

         User userCreated =  createUserService.executar(dto);


        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
