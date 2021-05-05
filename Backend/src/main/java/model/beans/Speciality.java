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

@XmlType(name = "speciality", propOrder = {"professor", "thematicArea"})
public class Speciality implements Serializable {

    public Speciality(Professor professor, ThematicArea thematicArea) {
        this.professor = professor;
        this.thematicArea = thematicArea;
    }

    public Speciality() {
    }

    public Professor getProfessor() {
        return professor;
    }

    @XmlElement(name = "professor")
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ThematicArea getThematicArea() {
        return thematicArea;
    }

    @XmlElement(name = "thematicArea")
    public void setThematicArea(ThematicArea thematicArea) {
        this.thematicArea = thematicArea;
    }

    protected String toHTMLOptionAreaProfessor() {
        StringBuilder r = new StringBuilder();

        r.append(String.format("<option value=\"%d\">%s %s %s</option>", getProfessor().getId(), getProfessor().getLastName1(), getProfessor().getLastName2(), getProfessor().getName()));

        return r.toString();
    }

    public String getHTMLOptionAreaProfessor() {
        return toHTMLOptionAreaProfessor();
    }

    public int generateCompoundIdentifier() {
        return Integer.parseInt(String.format("%d%d", getProfessor().getId(), getThematicArea().getId()));
    }

    private Professor professor;
    private ThematicArea thematicArea;
}
