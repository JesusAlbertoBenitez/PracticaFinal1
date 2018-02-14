/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.practicafinal.controller;

import com.seguritech.practicafinal.domain.Personas;
import com.seguritech.practicafinal.domain.repositories.PersonasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Damin
 */
@RestController
public class PersonasController {
    @Autowired
    private PersonasRepository persRepository;
    
    
    @RequestMapping(value="/personas")
    public List<Personas> listAll(){
        List<Personas>persona=persRepository.findAll();
        System.out.println(persona.size());
        return persona;
    }
    
    @GetMapping("/personas/{id}")
    public ResponseEntity<Personas> getPersonas(@PathVariable("id")Long id){
        Personas persona=persRepository.findOne(id);
        if(persona==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona);
    }
}
