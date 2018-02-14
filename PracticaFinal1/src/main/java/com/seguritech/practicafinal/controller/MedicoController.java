/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.practicafinal.controller;

import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.domain.repositories.MedicoRepository;
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
public class MedicoController {
    @Autowired
    private MedicoRepository medRepository;
    
    //Consulta de datos
    @RequestMapping(value = "/medico")
    public List<Medico> listAll(){
        List<Medico>medico=medRepository.findAll();
        System.out.println(medico.size());
        return medico;
    }
    //Insertar datos
    @PostMapping("/medico")
    public ResponseEntity<Medico> create(@RequestBody Medico medico) throws URISyntaxException{
        if(medico.getId()!=null){
            return ResponseEntity.badRequest().header("Error", "El id debe ser nulo").body(null);
        }
        medRepository.save(medico);
        return ResponseEntity.created(new URI("/medico/"+medico.getId())).body(medico);
    }
    //Actualizar datos
    @PutMapping("/medico")
    public ResponseEntity<Medico> update(@RequestBody Medico medico) throws URISyntaxException{
        if(medico.getId()==null){
            return ResponseEntity.badRequest().header("Error", "El id NO debe ser nulo").body(null);
        }
        medRepository.save(medico);
        return ResponseEntity.ok().body(medico);
    }   
    //Borrado de Datos
    @DeleteMapping("/medico/{id}")
    public ResponseEntity <Medico> delete(@PathVariable("id")Long id){
        medRepository.delete(id);
        return ResponseEntity.ok().build();
    }
    //Busqueda por id
    @GetMapping("/medico/{id}")
    public ResponseEntity<Medico> getMedico(@PathVariable("id")Long id){
        Medico medico=medRepository.findOne(id);
        if(medico==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(medico);
    }
}
