package org.benigaslo.controller;

import org.benigaslo.model.Agenda;
import org.benigaslo.model.Contacto;
import org.benigaslo.model.Modelo;
import org.benigaslo.view.Vista;

import java.util.List;

public class Controlador {

    Vista vista = new Vista();
    public Modelo modelo = new Modelo();



    public void aCorrer(){

        while(true) {
            vista.mostrarMenu();

            int o = vista.pedirOpcion();

            if (o == 1) {

                List<Agenda> agendas = modelo.obtenerListaAgendas(); // ver agendas
                vista.mostrarAgendas(agendas);


            } else if (o == 2) {
                NuevaAgendaDTO datos = vista.pedirDatosAgendaNueva(); // crear agenda
                modelo.guardarAgenda(datos);


            } else if (o == 4) {
                List<Agenda> listaRetorna = modelo.obtenerListaAgendas(); // añadir contacto

                ContactoDTO datosNuevoContacto = vista.pedirDatosContactoNuevo(listaRetorna);
                modelo.addContacto(datosNuevoContacto);


            } else if (o == 3) {
                List<Contacto> contactos = modelo.obtenerListaContactos();    //ver contactos
                vista.mostrarContactos(contactos);

            } else if (o == 5) {
                List<Contacto> contactos = modelo.obtenerListaContactos();     //eliminar contacto
                String eliminado = vista.eliminarContactos(contactos);
                modelo.eliminarContacto(eliminado);


            } else if (o == 6) {                                                //modificar contacto
                String nombreOriginal = vista.pedirContactoAModificar();

                Contacto contacto = modelo.buscarContactoConQuery(nombreOriginal);

                //vista.muestraContacto(contacto);

                ModificacionContactoDTO modificacionContactoDTO = vista.pedirDatosAModificar();

                modelo.modificarContactosConMod(contacto, modificacionContactoDTO);
            }
        }

    }
}
