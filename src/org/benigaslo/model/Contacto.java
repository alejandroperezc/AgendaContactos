package org.benigaslo.model;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    public String nombre;
    public String numTelf;
    public List<Info> infos = new ArrayList<>();


    public Contacto(String nombre, String numTelf) {
        this.nombre = nombre;
        this.numTelf = numTelf;
    }
}
