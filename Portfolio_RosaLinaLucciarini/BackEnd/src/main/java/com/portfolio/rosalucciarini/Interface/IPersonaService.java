
package com.portfolio.rosalucciarini.Interface;

import com.portfolio.rosalucciarini.Entidad.Persona;
import java.util.List;


public interface IPersonaService {
    //traer una persona
    public List<Persona> getPersona();
    
    //guardar un objrto de tipo persona
    public void savePersona(Persona persona);
    
    //eliminar un usuario bucado por id
    public void deletePersona(Long id);
    
    //buscar una persona por id
    public Persona findPersona(Long id);
    
    
}
