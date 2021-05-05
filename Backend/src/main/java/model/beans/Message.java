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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "message", propOrder = {"message"})
public class Message implements java.io.Serializable {

    public Message(String message) {
        this.message = message;
    }

    public Message() {
        this("");
    }

    public String getMessage() {
        return message;
    }

    @XmlElement(name = "message")
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String toString(){
        return message;
    }
    
    private String message;
}