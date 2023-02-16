package org.benigaslo.controller;

public class ContactoDTO {

    public String nombre;
    public String numTelf;
    public int numerosAgenda;

    public ContactoDTO(String nombre, String numTelf, int numerosAgenda) {
        this.nombre = nombre;
        this.numTelf = numTelf;
        this.numerosAgenda = numerosAgenda;
    }
}
