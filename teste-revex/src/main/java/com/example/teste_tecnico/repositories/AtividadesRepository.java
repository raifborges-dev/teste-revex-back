package com.example.teste_tecnico.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste_tecnico.model.AtividadesEntity;

@Repository
public interface AtividadesRepository extends JpaRepository<AtividadesEntity, Long>  {
    
    List<AtividadesEntity> findByDono(String dono);

    List<AtividadesEntity> findByDonoAndStatus(String dono, String status);

}
