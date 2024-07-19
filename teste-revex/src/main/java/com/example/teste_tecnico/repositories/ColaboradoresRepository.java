package com.example.teste_tecnico.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste_tecnico.model.ColaboradoresEntity;

@Repository
public interface ColaboradoresRepository extends JpaRepository<ColaboradoresEntity, Long>{

   List<ColaboradoresEntity> findBySetor(String Setor); 

   Optional<ColaboradoresEntity> findByNome(String Nome);

}
