package org.benigaslo;


import org.benigaslo.controller.Controlador;

public class Main {
    public static void main(String[] args) {

        Controlador controlador = new Controlador();

        new RellenadordeAgendas().rellenar(controlador.modelo.agendas);

        controlador.aCorrer();


    }
}