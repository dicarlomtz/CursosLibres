/*
    Universidad Nacional de Costa Rica
    Escuela de Informática
    EIF209 Programación IV, ciclo I 2021
    Mauricio Gutiérrez Vásquez 118260119
    Adolfo Di Carlo Martínez Martínez 118050228
    Yeikol Villalobos Herrera 702670531
    Proyecto #1, Sistema web CursosLibres.com
*/

package model.beans;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "administrator")
public class Administrator extends GenericUser {

    public Administrator(int id, UserAccountData accData, String lastName1, String lastName2, String name, int telephoneNumber, String email) {
        super(id, accData, lastName1,lastName2, name, telephoneNumber, email);
    }

    public Administrator() {
    }
}
