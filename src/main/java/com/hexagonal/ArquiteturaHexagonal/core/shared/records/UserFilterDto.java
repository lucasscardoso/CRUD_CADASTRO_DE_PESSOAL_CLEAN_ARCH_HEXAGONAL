package com.hexagonal.ArquiteturaHexagonal.core.shared.records;

public record UserFilterDto(String termoBusca, Integer pagina) {

    public UserFilterDto() {
        this(null, null);
    }

    //implementação vazia no momento, pois nao tenho busca por filtro/paginas
    //criada para resolver o problema do metodo findAll e contornar minha iUserCase
}
