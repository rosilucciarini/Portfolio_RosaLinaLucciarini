/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.rosalucciarini.Dto;

import javax.validation.constraints.NotBlank;


public class DtoSobremi {
       @NotBlank
     private String nombreS;
    @NotBlank
    private String descripcionS;
    @NotBlank
    private String img_url;

    public DtoSobremi() {
    }

    public DtoSobremi(String nombreS, String descripcionS, String img_url) {
        this.nombreS = nombreS;
        this.descripcionS = descripcionS;
        this.img_url = img_url;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getDescripcionS() {
        return descripcionS;
    }

    public void setDescripcionS(String descripcionS) {
        this.descripcionS = descripcionS;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
    
    
    
    
}
