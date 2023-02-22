package org.benigaslo.controller;

public class ModificacionContactoDTO {
    public String nombre;
    public String telefono;

    public ModificacionContactoDTO(String nombre, String numTelf) {
        this.nombre = nombre;
        this.telefono = numTelf;
    }
}
