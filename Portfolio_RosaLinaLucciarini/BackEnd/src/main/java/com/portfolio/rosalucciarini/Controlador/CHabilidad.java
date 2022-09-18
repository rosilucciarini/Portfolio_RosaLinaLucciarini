/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.rosalucciarini.Controlador;

import com.portfolio.rosalucciarini.Dto.DtoHabilidad;
import com.portfolio.rosalucciarini.Entidad.Habilidad;
import com.portfolio.rosalucciarini.Security.Controller.Mensaje;
import com.portfolio.rosalucciarini.Servidor.ServHabilidad;
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
@RequestMapping("/habilidad")
@CrossOrigin(origins = "https://frontendrosil.web.app")
public class CHabilidad {
    
    @Autowired
    ServHabilidad servHabilidad;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list() {
        List<Habilidad> list = servHabilidad.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id) {
        if (!servHabilidad.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = servHabilidad.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!servHabilidad.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        servHabilidad.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHabilidad dtohabilidad) {
        if (StringUtils.isBlank(dtohabilidad.getNombreH())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
       
        if (servHabilidad.existsByNombreH(dtohabilidad.getNombreH())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

           Habilidad habilidad = new Habilidad(
                dtohabilidad.getNombreH(), dtohabilidad.getProgreso()
        );
        servHabilidad.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHabilidad dtohabilidad) {
        if (!servHabilidad.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (servHabilidad.existsByNombreH(dtohabilidad.getNombreH()) && servHabilidad.getByNombreH(dtohabilidad.getNombreH()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtohabilidad.getNombreH())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

       Habilidad habilidad = servHabilidad.getOne(id).get();

        habilidad.setNombreH(dtohabilidad.getNombreH());
        
        habilidad.setProgreso(dtohabilidad.getProgreso());
        
        servHabilidad.save(habilidad);

        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
}