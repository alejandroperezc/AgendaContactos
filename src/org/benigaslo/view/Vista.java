package org.benigaslo.view;

import com.sun.security.jgss.GSSUtil;
import org.benigaslo.RellenadordeAgendas;
import org.benigaslo.controller.ContactoDTO;
import org.benigaslo.controller.ModificacionContactoDTO;
import org.benigaslo.controller.NuevaAgendaDTO;
import org.benigaslo.model.Agenda;
import org.benigaslo.model.Contacto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vista {
    Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\033[41m"+"MENU:"+"\033[0m");
        System.out.println("------------------------------");
        System.out.println("1) Ver agendas ---------------");
        System.out.println("2) Crear agenda --------------");
        System.out.println("3) Ver contactos -------------");
        System.out.println("4) Añadir contacto -----------");
        System.out.println("5) Eliminar contacto ---------");
        System.out.println("6) Modificar contacto --------");
       // System.out.println("7) Buscar contacto");
        System.out.println("------------------------------");
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

        agendas.forEach(agenda -> System.out.println(agenda.nombre + " (" + agenda.descripcion + ")"));
        System.out.println("------------------------------");
    }

    public void mostrarContactos(List<Contacto> contactos) {
        System.out.println("\033[46m"+"LISTA DE CONTACTOS"+"\033[0m");

        contactos.forEach(contacto -> System.out.println(contacto.nombre + " (" + contacto.numTelf + ")"));
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

        System.out.println("Introduce el numero de agenda donde quieres añadir el contacto:");
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

    public String pedirContactoAModificar() {
        System.out.println("Que contacto quieres modificar?");
        System.out.println("(Escribe el nombre exacto)");
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



}