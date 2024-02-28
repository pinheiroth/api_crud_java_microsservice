package com.th.ti_burguer.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.th.ti_burguer.shared.BurguerCompletoDto;

@Document("burguer")
public class Burguer {

    @Id
    private String id;
    private String nome;
    private List<String> ingredientes;
    private Tamanho tamanho;
    private Double valor;


    public Burguer(){}

    public Burguer(BurguerCompletoDto dto ){

        this.id = dto.id();
        this.nome = dto.nome();
        this.ingredientes = dto.ingredientes();
        this.tamanho = dto.tamanho();
        this.valor = dto.valor();

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    
}
