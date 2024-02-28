package com.th.ti_burguer.shared;

import java.util.List;

import com.th.ti_burguer.model.Tamanho;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BurguerCompletoDto(String id,
                                 @NotEmpty(message = "Campo nome deve ser informado!")
                                 @NotBlank(message = "Tá com caracteres em branco mas sem o nome.")
                                 String nome,
                                 @NotNull(message = "Valores válidos: uma_carne, duas_carnes, tres_carnes")
                                 Tamanho tamanho,
                                 List<String> ingredientes,
                                 @Positive(message = "Informe um valor positivo para o hamburguer.")
                                 Double valor ){

                                 
    
}
