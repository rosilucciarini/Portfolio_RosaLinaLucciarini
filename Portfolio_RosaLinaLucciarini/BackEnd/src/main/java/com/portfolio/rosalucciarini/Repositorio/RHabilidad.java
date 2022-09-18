/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.rosalucciarini.Repositorio;

import com.portfolio.rosalucciarini.Entidad.Habilidad;
import com.portfolio.rosalucciarini.Entidad.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RHabilidad extends JpaRepository<Habilidad, Integer> {
     public Optional<Habilidad> findByNombreH(String nombreH);
    public boolean existsByNombreH(String nombreH);
    
}
