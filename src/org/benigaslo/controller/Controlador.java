package org.benigaslo.controller;

import org.benigaslo.model.Agenda;
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

                List<Agenda> agendas = modelo.obtenerListaAgendas();
                vista.mostrarAgendas(agendas);


            } else if (o == 2) {
                NuevaAgendaDTO datos = vista.pedirDatosAgendaNueva();
                modelo.guardarAgenda(datos);


            } else if (o == 3) {
                List<Agenda> listaRetorna = modelo.obtenerListaAgendas();

                ContactoDTO datosNuevoContacto = vista.pedirDatosContactoNuevo(listaRetorna);
            }
        }


    }
}
