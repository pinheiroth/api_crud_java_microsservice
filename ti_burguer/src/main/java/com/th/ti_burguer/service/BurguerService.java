package com.th.ti_burguer.service;

import java.util.List;
import java.util.Optional;

import com.th.ti_burguer.shared.BurguerCompletoDto;
import com.th.ti_burguer.shared.BurguerDto;

public interface BurguerService {
    
    List<BurguerDto> obterTodas();
    Optional<BurguerCompletoDto> obterPorId(String id);
    BurguerCompletoDto cadastrar(BurguerCompletoDto dto);
    BurguerCompletoDto atualizarPorId(String id, BurguerCompletoDto dto);
    void excluirPorId(String id);
}
