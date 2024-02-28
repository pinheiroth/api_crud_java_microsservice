package com.ti.pedidos.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Burguer {
    
    private String nome;
    private List<String> ingredientes;
    private String tamnho;
    
}
