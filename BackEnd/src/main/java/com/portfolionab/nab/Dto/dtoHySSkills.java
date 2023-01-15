package com.portfolionab.nab.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoHySSkills {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    //Constructores
    public dtoHySSkills(){
    }
    
    public dtoHySSkills(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    //Getter&Setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
}
