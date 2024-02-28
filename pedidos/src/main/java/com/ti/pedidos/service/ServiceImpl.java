package com.ti.pedidos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ti.pedidos.httpClient.Cliente;
import com.ti.pedidos.model.Burguer;
import com.ti.pedidos.model.Pedido;
import com.ti.pedidos.repository.Repository;
import com.ti.pedidos.shared.PedidoDto;
import com.ti.pedidos.shared.PedidoDtoCompleto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ServiceImpl  implements com.ti.pedidos.service.Service{
    
    @Autowired
    private Repository repository; 

    @Autowired 
    private Cliente burguerClient;

    @Override
    public PedidoDtoCompleto cadastrar(PedidoDtoCompleto dto) {
        Pedido pedido = new Pedido(dto);
        repository.save(pedido);
        return new PedidoDtoCompleto(pedido.getId(),
                                     pedido.getNomeCliente(),
                                     pedido.getIdBurguer(),
                                     pedido.getValor(),
                                     pedido.getTempo());
    }

    @Override
    public List<PedidoDtoCompleto> obter() {
       return repository.findAll()
              .stream()
              .map(b -> new PedidoDtoCompleto(b.getId(),
                                              b.getNomeCliente(),
                                              b.getIdBurguer(),
                                              b.getValor(),
                                              b.getTempo()))
              .toList();                                   
    }


    @SuppressWarnings("null")
    @CircuitBreaker(name = "obter", fallbackMethod = "fallBackPedidosPorId")
    @Override
    public Optional<PedidoDto> obterPorId(UUID id){
        Optional<Pedido> pedido = repository.findById(id);

        if(pedido.isPresent()){
            Burguer burguer = burguerClient.obter(pedido.get().getIdBurguer());
            PedidoDto pedidoBurguer = new PedidoDto(pedido.get().getNomeCliente(),
                                                    pedido.get().getIdBurguer(),
                                                    burguer,
                                                    pedido.get().getValor(),
                                                    pedido.get().getTempo());
            return Optional.of(pedidoBurguer);                                        
        }
            return Optional.empty();
    }


    @SuppressWarnings("null")
    public Optional<PedidoDto> fallbackPedidosPorId(UUID id, Exception e){
        Optional<Pedido> pedido = repository.findById(id);

        if(pedido.isPresent()){
            PedidoDto pedidoBurguer = new PedidoDto(pedido.get().getNomeCliente(),
                                                    pedido.get().getIdBurguer(),
                                                    null,
                                                    pedido.get().getValor(),
                                                    pedido.get().getTempo());
            return Optional.of(pedidoBurguer);
        }
            return Optional.empty();
    }

    @SuppressWarnings("null")
    @Override
    public void excluir(UUID id) {
      repository.deleteById(id);
    }

    @SuppressWarnings("null")
    @Override
    public Optional<PedidoDto> atualizar(UUID id, PedidoDto dto) {
        Optional<Pedido> pedido = repository.findById(id);

        if(pedido.isPresent()){
            Pedido atualizar = new Pedido(dto);
            atualizar.setId(id);
            repository.save(atualizar);
            return Optional.of(dto);
        }
            return Optional.empty();
    }

}
