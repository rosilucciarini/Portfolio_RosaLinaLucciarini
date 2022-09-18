/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.rosalucciarini.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String nombrE;
    @NotBlank
    private String descripcionE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombrE, String descripcionE) {
        this.nombrE = nombrE;
        this.descripcionE = descripcionE;
    }

    public String getNombrE() {
        return nombrE;
    }

    public void setNombrE(String nombrE) {
        this.nombrE = nombrE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
     
    
}
