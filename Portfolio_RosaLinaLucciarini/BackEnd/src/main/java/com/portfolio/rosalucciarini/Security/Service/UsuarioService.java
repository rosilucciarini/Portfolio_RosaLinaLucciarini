/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.rosalucciarini.Security.Service;

import com.portfolio.rosalucciarini.Security.Entity.Usuario;
import com.portfolio.rosalucciarini.Security.Repository.UsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepository uSuarioRepository;
    
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return uSuarioRepository.findByNombreUsuario(nombreUsuario);
        
    }
    public boolean existsByNombreUsuario(String nombreUsuario){
        return uSuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
     public boolean existsByEmail(String email){
        return uSuarioRepository.existsByEmail(email);
    }
     public void save(Usuario usuario){
         uSuarioRepository.save(usuario);
     }  
}
