package com.hexagonal.ArquiteturaHexagonal.core.user.service;

import com.hexagonal.ArquiteturaHexagonal.core.shared.adressDto.ViaCepDTO;
import com.hexagonal.ArquiteturaHexagonal.core.shared.exception.AdressNotFoundException;
import com.hexagonal.ArquiteturaHexagonal.core.shared.exception.UserNotFoundException;
import com.hexagonal.ArquiteturaHexagonal.core.shared.records.EnderecoSaveResponseDTO;
import com.hexagonal.ArquiteturaHexagonal.core.shared.useCase.IUserCase;
import com.hexagonal.ArquiteturaHexagonal.core.user.entity.Endereco;
import com.hexagonal.ArquiteturaHexagonal.core.user.entity.User;
import com.hexagonal.ArquiteturaHexagonal.core.user.repository.AdressRepository;
import com.hexagonal.ArquiteturaHexagonal.core.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveAdress implements IUserCase<EnderecoSaveResponseDTO, ViaCepDTO> {

    private final AdressRepository adressRepo;
    private final UserRepository userRepo;

    public SaveAdress(AdressRepository adressRepo, UserRepository userRepo) {
        this.adressRepo = adressRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ViaCepDTO executar(EnderecoSaveResponseDTO entrada) {
        User usuario = userRepo.buscar(entrada.id()).orElseThrow(() -> new UserNotFoundException("O Usuario com id: %s" + " ," + "não localizado em nossa base de dados"));
        Endereco end = adressRepo.buscarPorCep(entrada.cep()).orElseThrow(
                    () -> new AdressNotFoundException(String.format("O Cep: %s " + ", não localizado em nossa base de dados",entrada.cep())) );

        end.setId(usuario.getId());

        end.setUser(usuario);

        ViaCepDTO dto = new ViaCepDTO();

        dto.setLogradouro(end.getLogradouro());
        dto.setBairro(end.getBairro());
        dto.setLocalidade(end.getLocalidade());
        dto.setEstado(end.getEstado());
        dto.setUf(end.getUf());

        adressRepo.salvar(end);

        return dto;

    }
}
