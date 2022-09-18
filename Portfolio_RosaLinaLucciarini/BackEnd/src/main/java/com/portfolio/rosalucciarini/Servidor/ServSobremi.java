/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.rosalucciarini.Servidor;

import com.portfolio.rosalucciarini.Entidad.Sobremi;
import com.portfolio.rosalucciarini.Repositorio.RSobremi;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServSobremi {
     @Autowired
    RSobremi rSobremi;
    
     public List<Sobremi> list(){
        return rSobremi.findAll();
    }
    
    public Optional<Sobremi> getOne(int id){
        return rSobremi.findById(id);
    }
    
    public Optional<Sobremi> getByNombreS(String nombreS){
        return rSobremi.findByNombreS(nombreS);
    }
    
    public void save(Sobremi sobremi){
        rSobremi.save(sobremi);
    }
    
    public void delete(int id){
        rSobremi.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSobremi.existsById(id);
    }
    
     
    public boolean existsByNombreS(String nombreS){
        return rSobremi.existsByNombreS(nombreS);    
    }
    
}
