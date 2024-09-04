package com.barragan.camiones.controllers;

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

import com.barragan.camiones.services.CamionesService;



@RequestMapping("/camiones")
@RestController
public class CamionesControllers {

    @Autowired
    CamionesService camionesService;


    @GetMapping
    public ResponseEntity<List<Camion>> listar(){
        List<Camion> choferes = this.camionesService.getAll();
        if(choferes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(choferes);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(name="id") Long id){
        Optional<Camion> c = camionesService.findById(id);
        if(c.isPresent()){
            return ResponseEntity.ok(c.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }  


    @PostMapping
    public ResponseEntity<?> post(@RequestBody Camion c){
        Camion save = camionesService.save(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }






}