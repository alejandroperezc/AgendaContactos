package org.benigaslo.view;

import org.benigaslo.controller.ContactoDTO;
import org.benigaslo.controller.ModificacionContactoDTO;
import org.benigaslo.controller.NuevaAgendaDTO;
import org.benigaslo.model.Agenda;
import org.benigaslo.model.Contacto;

import java.util.List;
import java.util.Scanner;

public class Vista {
    Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\033[45m"+"✉MENU✉                        "+"\033[0m");
        //System.out.println("\033[44m"+"                                "+"\033[0m");
        System.out.print("\033[44m"+" "+" 1)\uD83D\uDCD6Ver agendas"+"\033[0m");
        System.out.println("\033[44m"+"--------------"+"\033[44m"+" "+"\033[0m");
        System.out.print("\033[44m"+" "+" 2)➕Crear agenda"+"\033[0m");
        System.out.println("\033[44m"+"-------------"+"\033[44m"+" "+"\033[0m");
        System.out.print("\033[44m"+" "+" 3)\uD83D\uDC65Ver contactos"+"\033[0m");
        System.out.println("\033[44m"+"------------"+"\033[44m"+" "+"\033[0m");
        System.out.print("\033[44m"+" "+" 4)✅Añadir contacto"+"\033[0m");
        System.out.println("\033[44m"+"----------"+"\033[44m"+" "+"\033[0m");
        System.out.print("\033[44m"+" "+" 5)🗑Eliminar contacto"+"\033[0m");
        System.out.println("\033[44m"+"--------"+"\033[44m"+" "+"\033[0m");
        System.out.print("\033[44m"+" "+" 6)✏Editar contacto"+"\033[0m");
        System.out.println("\033[44m"+"----------"+"\033[44m"+" "+"\033[0m");
        //System.out.print("\033[44m"+" "+"\033[0m"+" 7) Buscar contacto");
        //System.out.println("           "+"\033[44m"+" "+"\033[0m");
        //System.out.println("\033[44m"+"                               "+"\033[0m"+"\033[44m"+" "+"\033[0m");
        System.out.print("\033[46m"+ "  7)❌Salir❌                   "+"\033[0m");
        System.out.println("                  ");

    }

    public int pedirOpcion() {
        System.out.println("\033[34m"+"Opcion: "+"\033[0m");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        return opcion;
    }

    public void mostrarAgendas(List<Agenda> agendas) {
        System.out.println("------------------------------");
        System.out.println("\033[46m"+"LISTA DE AGENDAS"+"\033[0m");

        agendas.forEach(agenda -> System.out.println("\033[33m" + agenda.nombre +"\033[0m" + " (" + agenda.descripcion + ")"));
        System.out.println("------------------------------");
    }

    public void mostrarContactos(List<Contacto> contactos) {
        System.out.println("------------------------------");
        System.out.println("\033[46m"+"LISTA DE CONTACTOS"+"\033[0m");

        contactos.forEach(contacto -> System.out.println("\033[33m" +"Nombre:  "+"\033[0m" + contacto.nombre+"   " + "\033[33m" +"Num:  "+"\033[0m" + contacto.numTelf ));
        System.out.println("------------------------------");
    }

    public NuevaAgendaDTO pedirDatosAgendaNueva() {
        System.out.println("\033[46m"+"CREAR AGENDA NUEVA"+"\033[0m");
        System.out.println("Introduce nombre de la agenda: ");
        String nombre = scanner.nextLine();

        System.out.println("Introduce descripcion de la agenda: ");
        String descripcion = scanner.nextLine();


        return new NuevaAgendaDTO(nombre, descripcion);

    }


    public ContactoDTO pedirDatosContactoNuevo(List<Agenda> list){
        System.out.println("\033[46m"+"AÑADIR CONTACTO"+"\033[0m");
        System.out.println("Introduce el nombre del contacto nuevo:");
        String nombre = scanner.nextLine();

        System.out.println("Introduce el numero de telefono del contacto nuevo:");
        String numTelf = scanner.nextLine();

        System.out.println("Introduce el numero de agenda donde quieres añadir el contacto (0,1,2...):");
        list.forEach(agenda -> System.out.println(agenda.nombre));
        int numerosAgenda = scanner.nextInt();
        return new ContactoDTO(nombre, numTelf, numerosAgenda);
    }

    public String eliminarContactos(List<Contacto> contactos) {
        System.out.println("\033[46m"+"ELIMINAR CONTACTO"+"\033[0m");
        System.out.println("Que contacto quieres eliminar?");
        System.out.println("(Escribe el nombre exacto)");
        contactos.forEach(contacto -> System.out.println(contacto.nombre));
        String eliminado = scanner.next();


        return eliminado;
    }

    public String pedirContactoAModificar(List<Contacto> contactos) {
        System.out.println("Que contacto quieres modificar?");
        System.out.println("(Escribe el nombre exacto)");
        contactos.forEach(contacto -> System.out.println(contacto.nombre + " (" + contacto.numTelf + ")"));
        String mod = scanner.nextLine();
        return mod;
    }

    public ModificacionContactoDTO pedirDatosAModificar() {
        System.out.println("Nuevo nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Nuevo numero:");
        String telefono = scanner.nextLine();
        return new ModificacionContactoDTO(nombre, telefono);
    }


    public void cerrarPrograma() {
        System.out.println("Cerrando programa...");
    }
}