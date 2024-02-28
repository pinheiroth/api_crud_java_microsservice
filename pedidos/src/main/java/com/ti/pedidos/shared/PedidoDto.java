package com.ti.pedidos.shared;

import com.ti.pedidos.model.Burguer;

public record PedidoDto(String nomeCliente,
                        String idBurguer,
                        Burguer dadosBurguer,
                        double valor,
                        String tempo) {
    
}
