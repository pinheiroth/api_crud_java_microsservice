package com.ti.pedidos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ti.pedidos.shared.PedidoDto;
import com.ti.pedidos.shared.PedidoDtoCompleto;

public interface Service {

    PedidoDtoCompleto cadastrar(PedidoDtoCompleto dto);
    List<PedidoDtoCompleto> obter();
    Optional<PedidoDto> obterPorId(UUID id);
    void excluir(UUID id);
    Optional<PedidoDto> atualizar(UUID id, PedidoDto dto);

}
