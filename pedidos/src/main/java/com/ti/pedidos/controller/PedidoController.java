package com.ti.pedidos.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ti.pedidos.shared.PedidoDto;
import com.ti.pedidos.shared.PedidoDtoCompleto;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private com.ti.pedidos.service.Service service;

   
    @PostMapping
    public ResponseEntity<PedidoDtoCompleto> cadastrar(@RequestBody PedidoDtoCompleto pedido) {
        return new ResponseEntity<>(service.cadastrar(pedido), HttpStatus.CREATED);
     }


    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> obterPedidoPorId(@PathVariable UUID id) {
        Optional<PedidoDto> retorno = service.obterPorId(id);

        if (retorno.isPresent()) {
            return new ResponseEntity<>(retorno.get(), HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPedido(@PathVariable UUID id) {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> atualizarPedido(@PathVariable UUID id, @RequestBody PedidoDto pedido) {
        Optional<PedidoDto> retorno = service.atualizar(id, pedido);

        if (retorno.isEmpty()) {
            return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
        } 
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
    }
    
}
