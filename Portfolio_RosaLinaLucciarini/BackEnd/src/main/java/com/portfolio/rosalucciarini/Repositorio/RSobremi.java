/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.rosalucciarini.Repositorio;

import com.portfolio.rosalucciarini.Entidad.Sobremi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RSobremi extends JpaRepository<Sobremi, Integer>{
    public Optional<Sobremi> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
    
    
}
