package com.hexagonal.ArquiteturaHexagonal.externals.controllers;

import com.hexagonal.ArquiteturaHexagonal.core.shared.adressDto.ViaCepDTO;
import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.BuscaUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class BuscaCepController {

    private final IUserCase<String, ViaCepDTO> buscaCepService;

    public BuscaCepController(IUserCase<String, ViaCepDTO> buscaCepService) {
        this.buscaCepService = buscaCepService;
    }

    @GetMapping("/{cep}/json/")
    public ResponseEntity<ViaCepDTO> buscarEnderecoPor(@PathVariable("cep") String cep) {
        ViaCepDTO dto =  buscaCepService.executar(cep);
        return ResponseEntity.ok(dto);
    }


}
