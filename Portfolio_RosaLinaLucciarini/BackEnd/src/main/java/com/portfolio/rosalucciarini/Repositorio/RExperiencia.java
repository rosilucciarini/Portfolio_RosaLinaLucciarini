/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.rosalucciarini.Repositorio;

import com.portfolio.rosalucciarini.Entidad.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia,Integer>{
    public Optional<Experiencia> findByNombrE(String nombrE);
    public boolean existsByNombrE(String nombrE);
}
