package com.barragan.choferes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barragan.choferes.models.Chofer;
import com.barragan.choferes.services.ChoferesService;

@RequestMapping("choferes")
@RestController
public class ChoferesController {
    @Autowired
    ChoferesService choferesService;


    @GetMapping
    public ResponseEntity<List<Chofer>> listar(){
        List<Chofer> choferes = this.choferesService.getAll();
        if(choferes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(choferes);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(name="id") Long id){
        Optional<Chofer> c = choferesService.findById(id);
        if(c.isPresent()){
            return ResponseEntity.ok(c.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }  


    @PostMapping
    public ResponseEntity<?> post(@RequestBody Chofer c){
        Chofer save = choferesService.save(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }





}
