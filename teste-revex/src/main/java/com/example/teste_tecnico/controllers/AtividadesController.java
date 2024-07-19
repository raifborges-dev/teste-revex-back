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

import com.example.teste_tecnico.model.Atividades;
import com.example.teste_tecnico.services.AtividadesService;

@Controller
public class AtividadesController {

    private final AtividadesService atividadesService;

    @Autowired
    public AtividadesController(final AtividadesService atividadesService){
        this.atividadesService = atividadesService;
    }

    @CrossOrigin
    @PutMapping(path = "/atividades/novo")
    public ResponseEntity<Atividades> createAtividade(@RequestBody final Atividades atividades){

        final Atividades savedAtividades = atividadesService.create(atividades);
        return new ResponseEntity<Atividades>(savedAtividades, HttpStatus.CREATED);

    }

    @CrossOrigin
    @GetMapping(path = "/atividades/id/{id}")
    public ResponseEntity<Atividades> findAtividadeByID(@PathVariable final Long id){
        final Optional<Atividades> foundAtividade = atividadesService.findById(id);
        return foundAtividade.map(atividade -> new ResponseEntity<Atividades>(atividade, HttpStatus.OK))
        .orElse(new ResponseEntity<Atividades>(HttpStatus.NOT_FOUND));
        
    }
    @CrossOrigin
    @GetMapping(path = "/atividades/{dono}")
    public ResponseEntity<List<Atividades>> findAtividadeByDono(@PathVariable final String dono){
        final List<Atividades> foundAtividade = atividadesService.findByDono(dono);
        return new ResponseEntity<List<Atividades>>(foundAtividade, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(path = "/atividades/{dono}/{status}")
    public ResponseEntity<List<Atividades>> findAtividadeByStatus(@PathVariable final String dono, @PathVariable final String status ){
        final List<Atividades> foundAtividade = atividadesService.findByDonoAndStatus(dono, status);
        return new ResponseEntity<List<Atividades>>(foundAtividade, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(path = "/atividade/todos")
    public ResponseEntity<List<Atividades>> listAtividades(){
        
        return new ResponseEntity<List<Atividades>>(atividadesService.listAtividades(), HttpStatus.OK);

    }
}
