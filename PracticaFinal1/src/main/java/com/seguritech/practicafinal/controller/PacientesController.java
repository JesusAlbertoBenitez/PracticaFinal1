/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.practicafinal.controller;

import com.seguritech.practicafinal.domain.Paciente;
import com.seguritech.practicafinal.domain.repositories.PacienteRepository;
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
public class PacientesController {
    @Autowired
    private PacienteRepository pacRepository;
    
    //Consulta de datos
    @RequestMapping(value = "/paciente")
    public List<Paciente> listAll(){
        List<Paciente>paciente=pacRepository.findAll();
        System.out.println(paciente.size());
        return paciente;
    }
    //Insertar datos
    @PostMapping("/paciente")
    public ResponseEntity<Paciente> create(@RequestBody Paciente paciente) throws URISyntaxException{
        if(paciente.getId()!=null){
            return ResponseEntity.badRequest().header("Error", "El id debe ser nulo").body(null);
        }
        pacRepository.save(paciente);
        return ResponseEntity.created(new URI("/paciente/"+paciente.getId())).body(paciente);
    }
    //Actualizar datos
    @PutMapping("/paciente")
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente) throws URISyntaxException{
        if(paciente.getId()==null){
            return ResponseEntity.badRequest().header("Error", "El id NO debe ser nulo").body(null);
        }
        pacRepository.save(paciente);
        return ResponseEntity.ok().body(paciente);
    }   
    //Borrado de Datos
    @DeleteMapping("/paciente/{id}")
    public ResponseEntity <Paciente> delete(@PathVariable("id")Long id){
        pacRepository.delete(id);
        return ResponseEntity.ok().build();
    }
    //Busqueda por id
    @GetMapping("/paciente/{id}")
    public ResponseEntity<Paciente> getPaciente(@PathVariable("id")Long id){
        Paciente paciente=pacRepository.findOne(id);
        if(paciente==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente);
    }
}
