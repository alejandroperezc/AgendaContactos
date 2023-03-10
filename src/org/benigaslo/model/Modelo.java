package org.benigaslo.model;

import org.benigaslo.RellenadordeAgendas;
import org.benigaslo.controller.ContactoDTO;
import org.benigaslo.controller.ModificacionContactoDTO;
import org.benigaslo.controller.NuevaAgendaDTO;

import java.util.ArrayList;
import java.util.List;

public class Modelo {

    public List<Agenda> agendas = new ArrayList<>();


    void afegirInfo (Contacto contacto, String descripcion, String valor){
        contacto.infos.add(new Info(descripcion, valor));
    }


    public void guardarAgenda(NuevaAgendaDTO datos){
        agendas.add(new Agenda(datos.nombre, datos.descripcion));
    }




    public List<Agenda> obtenerListaAgendas() {
        return agendas;
    }

    public List<Contacto> obtenerListaContactos() {
        List<Contacto> temporal = new ArrayList<>();

        for (Agenda agenda : agendas){
            for (Contacto contacto : agenda.contactos) {
                if (!temporal.contains(contacto)){
                    temporal.add(contacto);
                }
            }
        }

        return temporal;
    }

    public void addContacto(ContactoDTO datosNuevoContacto) {
        agendas.get(datosNuevoContacto.numerosAgenda).contactos.add(new Contacto(datosNuevoContacto.nombre, datosNuevoContacto.numTelf));
    }

    public void eliminarContacto(String eliminado) {

        for (Agenda agenda : agendas){
                agenda.contactos.removeIf(contacto -> contacto.nombre.equals(eliminado));
        }

    }

    public Contacto buscarContactoConQuery(String q) {
        for (Agenda agenda : agendas){
            for (Contacto contacto : agenda.contactos){
                if (contacto.nombre.toLowerCase().contains(q.toLowerCase())) {
                    return contacto;
                }
            }
        }
        return null;
    }

    public void modificarContactosConMod(Contacto original, ModificacionContactoDTO datos) {  // m=juan
        original.nombre = datos.nombre;
        original.numTelf = datos.telefono;
    }
}
