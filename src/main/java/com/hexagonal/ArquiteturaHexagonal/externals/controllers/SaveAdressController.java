package com.hexagonal.ArquiteturaHexagonal.externals.controllers;


import com.hexagonal.ArquiteturaHexagonal.core.shared.adressDto.ViaCepDTO;
import com.hexagonal.ArquiteturaHexagonal.core.shared.records.EnderecoSaveResponseDTO;
import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class SaveAdressController {

    private final IUserCase<EnderecoSaveResponseDTO, ViaCepDTO> saveAdressService;

    public SaveAdressController(IUserCase<EnderecoSaveResponseDTO, ViaCepDTO> saveAdressService) {
        this.saveAdressService = saveAdressService;
    }

    @PostMapping("/salvaendereco/{id}/{cep}")
    public ResponseEntity<ViaCepDTO> salvaEndereco(@PathVariable Long id, @PathVariable String cep ){

        EnderecoSaveResponseDTO entrada = new EnderecoSaveResponseDTO(cep,id);
        ViaCepDTO endereco = saveAdressService.executar(entrada);
        ViaCepDTO dto = new ViaCepDTO(endereco.getLogradouro(), endereco.getEstado(), endereco.getEstado(), endereco.getBairro(), endereco.getUf());
        return ResponseEntity.ok(dto);
    }
}
