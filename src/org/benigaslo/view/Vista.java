package org.benigaslo.view;

import org.benigaslo.RellenadordeAgendas;
import org.benigaslo.controller.ContactoDTO;
import org.benigaslo.controller.NuevaAgendaDTO;
import org.benigaslo.model.Agenda;
import org.benigaslo.model.Contacto;

import java.util.List;
import java.util.Scanner;

public class Vista {
    Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("MENU:");
        System.out.println("1) Ver agendas");
        System.out.println("2) Crear agenda");
        System.out.println("3) Añadir contacto");
        System.out.println("4) Ver contactos");
        System.out.println("5) Eliminar contacto");
        System.out.println("------------------------------");
    }

    public int pedirOpcion() {
        System.out.println("Opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        return opcion;
    }

    public void mostrarAgendas(List<Agenda> agendas) {
        System.out.println("------------------------------");
        System.out.println("LISTA DE AGENDAS");

        agendas.forEach(agenda -> System.out.println(agenda.nombre));
        System.out.println("------------------------------");
    }

    public void mostrarContactos(List<Contacto> contactos) {
        System.out.println("LISTA DE CONTACTOS");


       // for (Contacto contacto : agenda.contactos) {}

        contactos.forEach(contacto -> System.out.println(contacto.nombre));
    }

    public NuevaAgendaDTO pedirDatosAgendaNueva() {
        System.out.println("Introduce nombre de la agenda: ");
        String nombre = scanner.nextLine();

        System.out.println("Introduce descripcion de la agenda: ");
        String descripcion = scanner.nextLine();


        return new NuevaAgendaDTO(nombre, descripcion);

    }


    public ContactoDTO pedirDatosContactoNuevo(List<Agenda> list){
        System.out.println("Introduce el nombre del contacto nuevo:");
        String nombre = scanner.nextLine();

        System.out.println("Introduce el numero de telefono del contacto nuevo:");
        String numTelf = scanner.nextLine();

        System.out.println("Introduce el numero de agenda donde quieres añadir el contacto:");
        list.forEach(agenda -> System.out.println(agenda.nombre));
        int numerosAgenda = scanner.nextInt();
        return new ContactoDTO(nombre, numTelf, numerosAgenda);
    }

    public String eliminarContactos(List<Contacto> contactos) {
        System.out.println("Que contacto quieres eliminar?");

        contactos.forEach(contacto -> System.out.println(contacto.nombre));
        String nombre = scanner.next();
       return nombre;

    }
}