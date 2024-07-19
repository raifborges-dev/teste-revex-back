package com.example.teste_tecnico.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste_tecnico.model.Colaboradores;
import com.example.teste_tecnico.model.ColaboradoresEntity;
import com.example.teste_tecnico.repositories.ColaboradoresRepository;
import com.example.teste_tecnico.services.ColaboradoresService;

@Service
public class ColaboradoresServiceImpl implements ColaboradoresService{
    
    private final ColaboradoresRepository colaboradoresRepository;


    @Autowired
    public ColaboradoresServiceImpl(final ColaboradoresRepository colaboradoresRepository){
        this.colaboradoresRepository = colaboradoresRepository;
    }

    @Override
    public Colaboradores create(Colaboradores colaboradores) {
        final ColaboradoresEntity colaboradoresEntity = colaboradoresToColaboradoresEntity(colaboradores);
        return colaboradoresEntityToColaboradores(colaboradoresRepository.save(colaboradoresEntity));
    }

    private ColaboradoresEntity colaboradoresToColaboradoresEntity(Colaboradores colaboradores){
        return ColaboradoresEntity.builder()
        .id(colaboradores.getId())
        .nome(colaboradores.getNome())
        .salario(colaboradores.getSalario())
        .admissao(colaboradores.getAdmissao())
        .cargo(colaboradores.getCargo())
        .setor(colaboradores.getSetor())
        .build();
    }
    private Colaboradores colaboradoresEntityToColaboradores(ColaboradoresEntity colaboradores){
        return Colaboradores.builder()
        .id(colaboradores.getId())
        .nome(colaboradores.getNome())
        .salario(colaboradores.getSalario())
        .admissao(colaboradores.getAdmissao())
        .cargo(colaboradores.getCargo())
        .setor(colaboradores.getSetor())
        .build();
    }

    @Override
    public Optional<Colaboradores> findById(Long id) {
        final Optional<ColaboradoresEntity> foundColaborador = colaboradoresRepository.findById(id);
        return foundColaborador.map(colaboradores -> colaboradoresEntityToColaboradores(colaboradores));
    }

    @Override
    public List<Colaboradores> findBySetor(String setor) {
        final List<ColaboradoresEntity>foundColaboradores = colaboradoresRepository.findBySetor(setor);
        return foundColaboradores.stream().map(colaborador -> colaboradoresEntityToColaboradores(colaborador)).collect(Collectors.toList());
    }

    @Override
    public List<Colaboradores> listColaboradores(){
        final List<ColaboradoresEntity> foundColaboradores = colaboradoresRepository.findAll();
        return foundColaboradores.stream().map(colaborador -> colaboradoresEntityToColaboradores(colaborador)).collect(Collectors.toList());
    }

    @Override
    public Optional<Colaboradores> findByNome(String nome) {
        final Optional<ColaboradoresEntity> foundColaborador = colaboradoresRepository.findByNome(nome);
        return foundColaborador.map(colaboradores -> colaboradoresEntityToColaboradores(colaboradores));
    }

}
