/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.practicafinal.controller;

import com.seguritech.practicafinal.domain.Especialidades;
import com.seguritech.practicafinal.domain.repositories.EspecialidadesRepository;
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
 * @author Damin
 */
@RestController
public class EspecialidadesController {
    @Autowired
    private EspecialidadesRepository espRepository;
    
    //Consulta de datos
    @RequestMapping(value = "/espec")
    public List<Especialidades> listAll(){
        List<Especialidades>especialidad=espRepository.findAll();
        System.out.println(especialidad.size());
        return especialidad;
    }
    //Insertar datos
    @PostMapping("/espec")
    public ResponseEntity<Especialidades> create(@RequestBody Especialidades especialidad) throws URISyntaxException{
        if(especialidad.getId()!=null){
            return ResponseEntity.badRequest().header("Error", "El id debe ser nulo").body(null);
        }
        espRepository.save(especialidad);
        return ResponseEntity.created(new URI("/espec/"+especialidad.getId())).body(especialidad);
    }
    //Actualizar datos
    @PutMapping("/espec")
    public ResponseEntity<Especialidades> update(@RequestBody Especialidades especialidad) throws URISyntaxException{
        if(especialidad.getId()==null){
            return ResponseEntity.badRequest().header("Error", "El id NO debe ser nulo").body(null);
        }
        espRepository.save(especialidad);
        return ResponseEntity.ok().body(especialidad);
    }   
    //Borrado de Datos
    @DeleteMapping("/espec/{id}")
    public ResponseEntity <Especialidades> delete(@PathVariable("id")Long id){
        espRepository.delete(id);
        return ResponseEntity.ok().build();
    }
    //Busqueda por id
    @GetMapping("/espec/{id}")
    public ResponseEntity<Especialidades> getEspecialidad(@PathVariable("id")Long id){
        Especialidades especialidad=espRepository.findOne(id);
        if(especialidad==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(especialidad);
    }
}
