/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.practicafinal.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 *
 * @author Usuario
 */
@Entity
@DiscriminatorValue(value = "MEDICO")
public class Medico extends Personas{
    @Column(name = "especialidad_id")
    private Long idEspecialidad;
    
    @Column(name = "baja_logica")
    private Long bajaLogica;
    
    public Long getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Long getBajaLogica() {
        return bajaLogica;
    }

    public void setBajaLogica(Long bajaLogica) {
        this.bajaLogica = bajaLogica;
    }
}
