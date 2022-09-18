/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.rosalucciarini.Dto;

import javax.validation.constraints.NotBlank;


public class DtoHabilidad {
       @NotBlank
     private String nombreH;
    @NotBlank
    private int progreso;
    

    public DtoHabilidad() {
    }

    public DtoHabilidad(String nombreH, int progreso) {
        this.nombreH = nombreH; 
        this.progreso = progreso;
        
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }

}
