/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.practicafinal.controller;

import com.seguritech.practicafinal.domain.Turnos;
import com.seguritech.practicafinal.domain.repositories.TurnosRepository;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
public class TurnosController {
    @Autowired
    private TurnosRepository turnRepository;
    
    //Consulta de datos
    @RequestMapping(value = "/turno")
    public List<Turnos> listAll(){
        List<Turnos>turnos=turnRepository.findAll();
        System.out.println(turnos.size());
        return turnos;
    }
    //Insertar datos
    @PostMapping("/turno")
    public ResponseEntity<Turnos> create(@RequestBody Turnos turnos) throws URISyntaxException{
        if(turnos.getId()!=null){
            return ResponseEntity.badRequest().header("Error", "El id debe ser nulo").body(null);
        }
        turnRepository.save(turnos);
        return ResponseEntity.created(new URI("/turno/"+turnos.getId())).body(turnos);
    }
    //Actualizar datos
    @PutMapping("/turno")
    public ResponseEntity<Turnos> update(@RequestBody Turnos turnos) throws URISyntaxException{
        if(turnos.getId()==null){
            return ResponseEntity.badRequest().header("Error", "El id NO debe ser nulo").body(null);
        }
        turnRepository.save(turnos);
        return ResponseEntity.ok().body(turnos);
    }   
    //Borrado de Datos
    @DeleteMapping("/turno/{id}")
    public ResponseEntity <Turnos> delete(@PathVariable("id")Long id){
        turnRepository.delete(id);
        return ResponseEntity.ok().build();
    }
    //Busqueda por id
    @GetMapping("/turno/{id}")
    public ResponseEntity<Turnos> getTurnos(@PathVariable("id")Long id){
        Turnos turnos=turnRepository.findOne(id);
        if(turnos==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turnos);
    }
}
