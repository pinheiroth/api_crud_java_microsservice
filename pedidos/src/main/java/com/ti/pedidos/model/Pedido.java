package com.ti.pedidos.model;



import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ti.pedidos.shared.PedidoDto;
import com.ti.pedidos.shared.PedidoDtoCompleto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document("pedidos")
public class Pedido {

    @Id
    private UUID id;
    private String nomeCliente;
    private String idBurguer;
    private double valor;
    private String tempo;

    public Pedido(){

    }

    public Pedido(PedidoDtoCompleto dto){
        this.id = dto.id();
        this.nomeCliente = dto.nomeCliente();
        this.idBurguer = dto.idBurguer();
        this.valor = dto.valor();
        this.tempo = dto.tempo();
        
    }

    public Pedido(PedidoDto dto){
        this.nomeCliente = dto.nomeCliente();
        this.idBurguer = dto.idBurguer();
        this.valor = dto.valor();
        this.tempo = dto.tempo();
    }

}
