package com.hexagonal.ArquiteturaHexagonal.externals.interfaces;

import com.hexagonal.ArquiteturaHexagonal.core.shared.adressDto.ViaCepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface IViaCepClient {
    @GetMapping("/{cep}/json/")
    ViaCepDTO buscarEnderecoPor(@PathVariable("cep") String cep);
}
