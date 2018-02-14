/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.practicafinal.controller;

import com.seguritech.practicafinal.controller.AdministradorController;
import com.seguritech.practicafinal.domain.Administrador;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 *
 * @author Damin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerTest {
    
   private MockMvc mockMvc;
    
    @Autowired
    private AdministradorController controller;
    
    public AdminControllerTest() {
    }
  
    @Test
    public void testListAll() {
        System.out.println("listAll");
        List<Administrador> listAll=controller.listAll();
        assertEquals(listAll.size(), 4);
    }

 
}
