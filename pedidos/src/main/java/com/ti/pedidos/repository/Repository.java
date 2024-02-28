package com.ti.pedidos.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ti.pedidos.model.Pedido;

public interface Repository extends MongoRepository<Pedido, UUID> {
    
}
