package com.example.teste_tecnico.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste_tecnico.model.Atividades;
import com.example.teste_tecnico.model.AtividadesEntity;
import com.example.teste_tecnico.repositories.AtividadesRepository;
import com.example.teste_tecnico.services.AtividadesService;

@Service
public class AtividadesServiceImpl implements AtividadesService{
    

    private final AtividadesRepository atividadesRepository;

    @Autowired
    public AtividadesServiceImpl(final AtividadesRepository atividadesRepository){
        this.atividadesRepository = atividadesRepository;
    }

    @Override
    public Atividades create(Atividades atividades) {
        final AtividadesEntity atividadesEntity = atividadesToAtividadesEntity(atividades);
        return atividadesEntityToAtividades(atividadesRepository.save(atividadesEntity));
    }

    @Override
    public Optional<Atividades> findById(Long id) {
        final Optional<AtividadesEntity> foundAtividade = atividadesRepository.findById(id);
        return foundAtividade.map(atividades -> atividadesEntityToAtividades(atividades));
    }

    @Override
    public List<Atividades> listAtividades() {
        final List<AtividadesEntity> foundAtividades = atividadesRepository.findAll();
        return foundAtividades.stream()
        .map(atividades -> atividadesEntityToAtividades(atividades)).collect(Collectors.toList());
    }

    private AtividadesEntity atividadesToAtividadesEntity(Atividades atividades){
        return AtividadesEntity.builder()
        .id(atividades.getId())
        .descricao(atividades.getDescricao())
        .status(atividades.getStatus())
        .dono(atividades.getDono())
        .build();
    }

    private Atividades atividadesEntityToAtividades(AtividadesEntity atividades){
        return Atividades.builder()
        .id(atividades.getId())
        .descricao(atividades.getDescricao())
        .status(atividades.getStatus())
        .dono(atividades.getDono())
        .build();
    }

    @Override
    public List<Atividades> findByDono(String dono) {
        final List<AtividadesEntity> foundAtividades = atividadesRepository.findByDono(dono);
        return foundAtividades.stream()
        .map(atividades -> atividadesEntityToAtividades(atividades)).collect(Collectors.toList());
    }

    @Override
    public List<Atividades> findByDonoAndStatus(String dono, String status) {
        final List<AtividadesEntity> foundAtividades = atividadesRepository.findByDonoAndStatus(dono,status);
        return foundAtividades.stream()
        .map(atividades -> atividadesEntityToAtividades(atividades)).collect(Collectors.toList());
    }

}
