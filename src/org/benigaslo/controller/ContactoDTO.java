package org.benigaslo.controller;

public class ContactoDTO {

    public String nombre;
    public String numTelf;
    public String numerosAgenda;

    public ContactoDTO(String nombre, String numTelf, String numerosAgenda) {
        this.nombre = nombre;
        this.numTelf = numTelf;
        this.numerosAgenda = numerosAgenda;
    }
}
