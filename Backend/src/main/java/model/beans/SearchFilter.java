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

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "searchFilter", propOrder = {"parameter"})
public class SearchFilter implements Serializable {

    public SearchFilter(String parameter) {
        this.parameter = parameter;
    }

    public SearchFilter() {
        this("");
    }

    public String getParameter() {
        return parameter;
    }

    @XmlElement(name = "parameter")
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return parameter;
    }

    private String parameter;
}
