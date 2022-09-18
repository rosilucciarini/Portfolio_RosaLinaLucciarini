/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.rosalucciarini.Controlador;

import com.portfolio.rosalucciarini.Dto.DtoSobremi;
import com.portfolio.rosalucciarini.Entidad.Sobremi;
import com.portfolio.rosalucciarini.Security.Controller.Mensaje;
import com.portfolio.rosalucciarini.Servidor.ServSobremi;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sobremi")
@CrossOrigin(origins = "https://frontendrosil.web.app")
public class CSobremi {
    
     @Autowired
    ServSobremi servSobremi;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Sobremi>> list() {
        List<Sobremi> list = servSobremi.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Sobremi> getById(@PathVariable("id") int id) {
        if (!servSobremi.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Sobremi sobremi = servSobremi.getOne(id).get();
        return new ResponseEntity(sobremi, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!servSobremi.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        servSobremi.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSobremi dtosobremi) {
        if (StringUtils.isBlank(dtosobremi.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
       
        if (servSobremi.existsByNombreS(dtosobremi.getNombreS())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

           Sobremi sobremi = new Sobremi(
                dtosobremi.getNombreS(), dtosobremi.getDescripcionS(), dtosobremi.getImg_url()
        );
        servSobremi.save(sobremi);
        return new ResponseEntity(new Mensaje("Creado"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSobremi dtosobremi) {
        if (!servSobremi.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (servSobremi.existsByNombreS(dtosobremi.getNombreS()) && servSobremi.getByNombreS(dtosobremi.getNombreS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtosobremi.getNombreS())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

       Sobremi sobremi = servSobremi.getOne(id).get();

        sobremi.setNombreS(dtosobremi.getNombreS());
        
        sobremi.setDescripcionS(dtosobremi.getDescripcionS());
        sobremi.setImg_url(dtosobremi.getImg_url());
        
        servSobremi.save(sobremi);

        return new ResponseEntity(new Mensaje("Actualizado"), HttpStatus.OK);
    }
    
}
