package org.benigaslo;

import org.benigaslo.model.Agenda;
import org.benigaslo.model.Contacto;

import java.util.List;

public class RellenadordeAgendas {

    void rellenar(List<Agenda> agendas) {
        Agenda agenda1 = new Agenda("personal", "copas de trabajo");
        Agenda agenda2 = new Agenda("work", "copas de trabajo");


        Contacto contacto1 = new Contacto("juan", "3254552211");
        Contacto contacto2 = new Contacto("anna", "1111111111");
        Contacto contacto4 = new Contacto("luis", "2222222222");
        Contacto contacto3 = new Contacto("pepe", "3333333333");

        agenda1.contactos.add(contacto1);
        agenda1.contactos.add(contacto2);
        agenda1.contactos.add(contacto4);

        agenda2.contactos.add(contacto3);
        agenda2.contactos.add(contacto4);

        agendas.add(agenda1);
        agendas.add(agenda2);


    }
}
