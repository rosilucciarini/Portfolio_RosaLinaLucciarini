
package com.portfolio.rosalucciarini.Repositorio;

import com.portfolio.rosalucciarini.Entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepositorio extends JpaRepository<Persona,Long>{
    
}
