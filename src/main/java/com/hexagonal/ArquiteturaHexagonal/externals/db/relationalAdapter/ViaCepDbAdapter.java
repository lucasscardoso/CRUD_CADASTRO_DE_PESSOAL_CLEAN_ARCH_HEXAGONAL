package com.hexagonal.ArquiteturaHexagonal.externals.db.relationalAdapter;


import com.hexagonal.ArquiteturaHexagonal.core.shared.adressDto.ViaCepDTO;
import com.hexagonal.ArquiteturaHexagonal.core.user.entity.Endereco;
import com.hexagonal.ArquiteturaHexagonal.core.user.entity.User;
import com.hexagonal.ArquiteturaHexagonal.core.user.repository.AdressRepository;
import com.hexagonal.ArquiteturaHexagonal.externals.interfaces.IViaCepClient;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ViaCepDbAdapter implements AdressRepository {

    private final IViaCepClient viaCepClient;

    public ViaCepDbAdapter(IViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    @Override
    public Endereco salvar(Endereco endereco) {
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
