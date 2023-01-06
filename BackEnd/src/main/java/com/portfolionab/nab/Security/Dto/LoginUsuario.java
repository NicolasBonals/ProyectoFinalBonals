
package com.portfolionab.nab.Security.Dto;

import jakarta.validation.constraints.NotBlank;

public class LoginUsuario {
    @NotBlank //para que no esten vacios
    private String nombreUsuario;
    @NotBlank
    private String password;
    
    //constructores
    
    public LoginUsuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }
    
    //Getters&Setters

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
