/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.practicafinal.domain.repositories;

import com.seguritech.practicafinal.domain.Turnos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Damin
 */
public interface TurnosRepository extends JpaRepository<Turnos, Long>{
    
}
