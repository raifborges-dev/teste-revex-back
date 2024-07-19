package com.example.teste_tecnico.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Atividades {
    private Long id;

    private String descricao;

    private String status;

    private String dono;
}
