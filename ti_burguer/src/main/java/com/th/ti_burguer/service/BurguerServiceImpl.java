package com.th.ti_burguer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.th.ti_burguer.model.Burguer;
import com.th.ti_burguer.repository.BurguerRepository;
import com.th.ti_burguer.shared.BurguerCompletoDto;
import com.th.ti_burguer.shared.BurguerDto;

@Service
public class BurguerServiceImpl  implements BurguerService {


    @Autowired
    private BurguerRepository repositorio;

    @Override
    public List<BurguerDto> obterTodas() {
        return repositorio.findAll()
        .stream()
        .map(b -> new BurguerDto(b.getNome(), b.getIngredientes()))
        .toList();
       
    }

    @SuppressWarnings("null")
    @Override
    public Optional<BurguerCompletoDto> obterPorId(String id) {
       Optional<Burguer> burguer = repositorio.findById(id);

       if (burguer.isPresent()) {
        return Optional.of(new BurguerCompletoDto(burguer.get().getId(),
                                                 burguer.get().getNome(),
                                                 burguer.get().getTamanho(),
                                                 burguer.get().getIngredientes(),
                                                 burguer.get().getValor()));
    } else {
        return Optional.empty();
    }
}
    

    @Override
    public BurguerCompletoDto cadastrar(BurguerCompletoDto dto) {
        Burguer burguer = new Burguer(dto);
        repositorio.save(burguer);

        return new BurguerCompletoDto(burguer.getId(),
                                       burguer.getNome(),
                                       burguer.getTamanho(),
                                       burguer.getIngredientes(),
                                       burguer.getValor());

    }

    @SuppressWarnings("null")
    @Override
    public BurguerCompletoDto atualizarPorId(String id, BurguerCompletoDto dto) {
        Burguer burguer = repositorio.findById(id).orElse(null);

        if(burguer != null){
            Burguer burguerAtualizado = new Burguer(dto);
            burguerAtualizado.setId(id);
            repositorio.save(burguerAtualizado);
            return new BurguerCompletoDto(burguerAtualizado.getId(),
                                            burguerAtualizado.getNome(),
                                            burguerAtualizado.getTamanho(),
                                            burguerAtualizado.getIngredientes(),
                                            burguerAtualizado.getValor());
        }else{
            return null;
        }
    }

    @SuppressWarnings("null")
    @Override
    public void excluirPorId(String id) {
      repositorio.deleteById(id);
    }
    
}
