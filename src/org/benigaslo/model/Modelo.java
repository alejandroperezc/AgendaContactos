package org.benigaslo.model;

import org.benigaslo.controller.ContactoDTO;
import org.benigaslo.controller.NuevaAgendaDTO;

import java.util.ArrayList;
import java.util.List;

public class Modelo {

    public List<Agenda> agendas = new ArrayList<>();

    public List<Contacto> buscarContactos(String text) {
        return null;
    }
    
    void afegirInfo (Contacto contacto, String descripcion, String valor){
        contacto.infos.add(new Info(descripcion, valor));
    }


    public void guardarAgenda(NuevaAgendaDTO datos){
        agendas.add(new Agenda(datos.nombre, datos.descripcion));
    }


    public List<Agenda> obtenerListaAgendas() {
        return agendas;
    }
}
