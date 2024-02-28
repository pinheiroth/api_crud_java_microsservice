package com.th.ti_burguer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.th.ti_burguer.service.BurguerService;
import com.th.ti_burguer.shared.BurguerCompletoDto;
import com.th.ti_burguer.shared.BurguerDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/burguers")
public class controller {

    @Autowired
    private BurguerService service;

    @GetMapping("/porta")
    private String obterPorta(@Value("${local.server.port}") String porta) {
        return "A instância que respondeu a requisição está rodando na porta " + porta;
    }

     @GetMapping
    private ResponseEntity<List<BurguerDto>> obterTodosBurguers() {
        return new ResponseEntity<>(service.obterTodas(), HttpStatus.OK);
    }

     @GetMapping("/{id}")
    private ResponseEntity<BurguerCompletoDto> obterBurguersPorId(@PathVariable String id) {
        Optional<BurguerCompletoDto> pizza = service.obterPorId(id);

        if (pizza.isPresent()) {
            return new ResponseEntity<>(pizza.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<BurguerCompletoDto> cadastrarBurguer(@RequestBody @Valid BurguerCompletoDto burguer) {
        return new ResponseEntity<>(service.cadastrar(burguer), HttpStatus.CREATED);
    }

     @PutMapping("/{id}")
    private ResponseEntity<BurguerCompletoDto> atualizarBurguer(@PathVariable String id, @RequestBody @Valid BurguerCompletoDto burguer) {
        BurguerCompletoDto burguerAtualizado = service.atualizarPorId(id, burguer);

        if (burguerAtualizado != null) {
            return new ResponseEntity<>(burguerAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirPorId(@PathVariable String id) {
        service.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
