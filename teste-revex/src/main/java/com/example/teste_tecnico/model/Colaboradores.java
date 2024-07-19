package com.example.teste_tecnico.model;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Colaboradores {

    private long id;

    private String nome;

    private String cargo;

    private Date admissao;

    private String setor;

    private double salario;

}
