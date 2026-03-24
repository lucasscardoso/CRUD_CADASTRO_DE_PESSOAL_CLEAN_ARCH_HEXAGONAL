package com.hexagonal.ArquiteturaHexagonal.externals.db.relationalAdapter;


import com.hexagonal.ArquiteturaHexagonal.core.shared.adressDto.ViaCepDTO;
import com.hexagonal.ArquiteturaHexagonal.core.shared.exception.UserNotFoundException;
import com.hexagonal.ArquiteturaHexagonal.core.user.entity.Endereco;
import com.hexagonal.ArquiteturaHexagonal.core.user.entity.User;
import com.hexagonal.ArquiteturaHexagonal.core.user.repository.AdressRepository;
import com.hexagonal.ArquiteturaHexagonal.externals.db.repository.SpringDataUserRepository;
import com.hexagonal.ArquiteturaHexagonal.externals.entity.AdressEntity;
import com.hexagonal.ArquiteturaHexagonal.externals.entity.UserEntity;
import com.hexagonal.ArquiteturaHexagonal.externals.interfaces.IViaCepClient;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ViaCepDbAdapter implements AdressRepository {

    private final IViaCepClient viaCepClient;
    private final SpringDataUserRepository jpaRepo;

    public ViaCepDbAdapter(IViaCepClient viaCepClient,SpringDataUserRepository jpaRepo) {
        this.viaCepClient = viaCepClient;
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        AdressEntity entity = AdressEntity.fromDomain(endereco);
        Optional<UserEntity> userEntity = jpaRepo.findById(endereco.getUser().getId()).orElseThrow(() -> new UserNotFoundException("usuario nao loxaliza"));

        entity.setUsuario(userEntity);

        return null;


    }

    @Override
    public Optional<Endereco> buscarPorCep(String cep) {
        ViaCepDTO dto = viaCepClient.buscarEnderecoPor(cep);
        if (dto == null || dto.getLogradouro() == null) {
            return Optional.empty();
        }
        Endereco end = new Endereco();
        end.setLogradouro(dto.getLogradouro());
        end.setBairro(dto.getBairro());
        end.setEstado(dto.getEstado());
        end.setLocalidade(dto.getLocalidade());
        end.setUf(dto.getUf());

        return Optional.of(end);

    }

    @Override
    public User alterarEndereco(Long id, Endereco salvar) {
        return null;
    }
}
