package com.example.teste_tecnico.services;

import java.util.List;
import java.util.Optional;


import com.example.teste_tecnico.model.Atividades;

public interface AtividadesService {

    Atividades create(Atividades atividades);

    Optional<Atividades> findById(Long id);

    List<Atividades> findByDono(String dono);

    List<Atividades> findByDonoAndStatus(String dono, String status);

    List<Atividades> listAtividades();
}
