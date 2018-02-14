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
@DiscriminatorValue(value = "PACIENTE")
public class Paciente extends Personas{
    @Column(name = "obra_social_id")
    private Long idObraSocial;
    
    public Long getIdObraSocial() {
        return idObraSocial;
    }

    public void setIdObraSocial(Long idObraSocial) {
        this.idObraSocial = idObraSocial;
    }
}
