package com.example.teste_tecnico.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.teste_tecnico.model.Colaboradores;
import com.example.teste_tecnico.services.AtividadesService;
import com.example.teste_tecnico.services.ColaboradoresService;

@Controller
public class ColaboradoresController {

    private final ColaboradoresService colaboradoresService;

    @Autowired
    public ColaboradoresController(final ColaboradoresService colaboradoresService, AtividadesService atividadesService){
        this.colaboradoresService = colaboradoresService;
    }
    @CrossOrigin
    @PutMapping(path = "/colaboradores/novo")
    public ResponseEntity<Colaboradores> createColaboradores(@RequestBody final Colaboradores colaboradores){
            
        final Colaboradores savedColaboradores = colaboradoresService.create(colaboradores);
        return new ResponseEntity<Colaboradores>( savedColaboradores, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping(path = "/colaboradores/id/{id}")
    public ResponseEntity<Colaboradores> findColaboradoresId(@PathVariable final Long id){
        
        final Optional<Colaboradores> foundColaborador = colaboradoresService.findById(id);
        return foundColaborador.map(colaborador -> new ResponseEntity<Colaboradores>(colaborador, HttpStatus.OK))
        .orElse(new ResponseEntity<Colaboradores>(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin
    @GetMapping(path = "/colaboradores/nome/{nome}")
    public ResponseEntity<Colaboradores> findColaboradoresNome(@PathVariable final String nome){
        
        final Optional<Colaboradores> foundColaborador = colaboradoresService.findByNome(nome);
        return foundColaborador.map(colaborador -> new ResponseEntity<Colaboradores>(colaborador, HttpStatus.OK))
        .orElse(new ResponseEntity<Colaboradores>(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin
    @GetMapping(path = "/colaboradores/setor/{setor}")
    public ResponseEntity<List<Colaboradores>> findColaboradoresSetor(@PathVariable final String setor){
    
        return new ResponseEntity<List<Colaboradores>>(colaboradoresService.findBySetor(setor), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(path = "/colaboradores/todos")
    public ResponseEntity<List<Colaboradores>> listColaboradores(){
    
        return new ResponseEntity<List<Colaboradores>>(colaboradoresService.listColaboradores(), HttpStatus.OK);
    }

}

