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

@XmlType(name = "enrollment", propOrder = {"student", "group", "course", "condition"})
public class Enrollment implements Serializable {

    public Enrollment(Student student, CourseGroup group, Course course, Condition condition, int grade) {
        this.student = student;
        this.group = group;
        this.course = course;
        this.condition = condition;
        this.grade = grade;
    }

    public Enrollment() {
    }

    public Student getStudent() {
        return student;
    }

    @XmlElement(name = "student")
    public void setStudent(Student student) {
        this.student = student;
    }

    public CourseGroup getGroup() {
        return group;
    }

    @XmlElement(name = "group")
    public void setGroup(CourseGroup group) {
        this.group = group;
    }

    public Course getCourse() {
        return course;
    }

    @XmlElement(name = "course")
    public void setCourse(Course course) {
        this.course = course;
    }

    @XmlElement(name = "condition")
    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public int getGrade() {
        return grade;
    }

    @XmlElement(name = "grade")
    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();

        return r.toString();
    }

    protected String toHTMLTableAssignGrades() {
        StringBuilder r = new StringBuilder();

        r.append("<tr>");
        r.append(String.format("<td>%d</td>", getStudent().getId()));
        r.append(String.format("<td>%s %s %s</td>", getStudent().getName(), getStudent().getLastName1(), getStudent().getLastName2()));
        r.append(String.format("<td><input class=\"input\" type=\"number\" min=\"0\" max=\"10\" name=\"%s\" placeholder=\"%d\" title=\"Debe ingresar el formato: XX {1-10}\"></td>", generateCompoundIdentifier(), getGrade()));
        r.append("</tr>");

        return r.toString();
    }

    public String getHTMLTableAssignGrades() {
        return toHTMLTableAssignGrades();
    }

    protected String toHTMLTableStudent() {
        StringBuilder r = new StringBuilder();

        r.append("<tr>");
        r.append(String.format("<td>%d</td>", getStudent().getId()));
        r.append(String.format("<td>%d</td>", getCourse().getId()));
        r.append(String.format("<td>%s</td>", getCourse().getDescription()));
        r.append(String.format("<td>%d</td>", getGroup().getGroupNumber()));
        r.append(String.format("<td>%s</td>", getCondition().getDescription()));
        r.append(String.format("<td>%d</td>", getGrade()));
        r.append("</tr>");

        return r.toString();
    }
    
    public String getHTMLTableStudent() {
        return toHTMLTableStudent();
    }

    public String generateCompoundIdentifier() {
        return String.format("%d-%d-%d", getStudent().getId(), getGroup().getGroupNumber(), getCourse().getId());
    }

    private Student student;
    private CourseGroup group;
    private Course course;
    private Condition condition;
    private int grade;
}
