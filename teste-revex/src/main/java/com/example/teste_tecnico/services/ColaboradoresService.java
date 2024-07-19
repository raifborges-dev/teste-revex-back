package com.example.teste_tecnico.services;

import java.util.List;
import java.util.Optional;

import com.example.teste_tecnico.model.Colaboradores;

public interface ColaboradoresService {

    Colaboradores create(Colaboradores colaboradores);
    
    Optional<Colaboradores> findById(Long id);

    Optional<Colaboradores> findByNome(String nome);

    List<Colaboradores> findBySetor(String setor);

    List<Colaboradores> listColaboradores();

}
