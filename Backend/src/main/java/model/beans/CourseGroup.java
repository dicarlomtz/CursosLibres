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

@XmlType(name = "courseGroup", propOrder = {"groupNumber", "course", "professor", "promotion"})
public class CourseGroup implements Serializable {

    public CourseGroup(int groupNumber, Course course, Professor professor, boolean promotion) {
        this.groupNumber = groupNumber;
        this.course = course;
        this.professor = professor;
        this.promotion = promotion;
    }

    public CourseGroup() {
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    @XmlElement(name = "groupNumber")
    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Course getCourse() {
        return course;
    }

    @XmlElement(name = "course")
    public void setCourse(Course course) {
        this.course = course;
    }

    public Professor getProfessor() {
        return professor;
    }

    @XmlElement(name = "professor")
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public boolean getPromotion() {
        return promotion;
    }

    @XmlElement(name = "promotion")
    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    protected String toHTMLTableProfessor() {
        StringBuilder r = new StringBuilder();

        r.append("<tr>");
        r.append(String.format("<td>%d</td>", getGroupNumber()));
        r.append(String.format("<td>%s</td>", getCourse().getDescription()));
        r.append(String.format("<td><form action=\"EnrolledStudentsService\" method=\"POST\"><button class=\"bn-table\" name=\"selectedGroup\" value=\"%d\">Asignar</button></td></form>", getGroupNumber()));
        r.append("</tr>");

        return r.toString();
    }

    public String getHTMLTableProfessor() {
        return toHTMLTableProfessor();
    }

    public int generateCompoundIdentifier() {
        return Integer.parseInt(String.format("%d%d", getGroupNumber(), getCourse().getId()));
    }

    public String getIDFormat()
    {
        return String.format("%d-%d", getCourse().getId(), getGroupNumber());
    }
    
    private int groupNumber;
    private Course course;
    private Professor professor;
    private boolean promotion;
}
