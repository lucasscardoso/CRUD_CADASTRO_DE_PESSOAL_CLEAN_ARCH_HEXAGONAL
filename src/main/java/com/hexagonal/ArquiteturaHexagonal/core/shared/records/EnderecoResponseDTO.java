package com.hexagonal.ArquiteturaHexagonal.core.shared.records;

public record EnderecoResponseDTO(
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        String estado
)
{}
