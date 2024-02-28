package com.ti.pedidos.shared;

import java.util.UUID;


public record PedidoDtoCompleto(UUID id,
                                String nomeCliente,
                                String idBurguer,
                                double valor,
                                String tempo  ) {
    
}
