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

@XmlType(name = "schedule", propOrder = {"sequence", "group", "course", "day", "hour"})
public class Schedule implements Serializable {

    public Schedule(int sequence, CourseGroup group, Course course, int day, int hour) {
        this.sequence = sequence;
        this.group = group;
        this.course = course;
        this.day = day;
        this.hour = hour;
    }

    public Schedule() {
    }

    public int getSequence() {
        return sequence;
    }

    @XmlElement(name = "sequence")
    public void setSequence(int sequence) {
        this.sequence = sequence;
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

    public int getDay() {
        return day;
    }

    @XmlElement(name = "day")
    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    @XmlElement(name = "hour")
    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();

        return r.toString();
    }
    
     protected String toHTMLTable() {
        StringBuilder r = new StringBuilder();
        
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<td>%d</td>\n", this.getGroup().getGroupNumber()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", this.getDay()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", this.getHour()));
        r.append(String.format("\t\t\t\t<td><form action=\"EnrollGroupStudentService\" method=\"POST\"><button name=\"groupNumber\" class=\"bn-table\" value=\"%d\">%s</button></form></td>\n", getGroup().getGroupNumber(), "Matricular"));
        r.append("\t\t\t</tr>\n");
        
        return r.toString();
    }

    public String getHTMLTable() {
        return toHTMLTable();
    }
    
      protected String toHTMLTableAdmin() {
        StringBuilder r = new StringBuilder();
        
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<td>%d</td>\n", this.getGroup().getGroupNumber()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", this.getDay()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", this.getHour()));
        r.append("\t\t\t</tr>\n");
        
        return r.toString();
    }

    public String getHTMLTableAdmin() {
        return toHTMLTableAdmin();
    }
    
    public int generateCompoundIdentifier() {
        return Integer.parseInt(String.format("%d%d%d", getSequence(), getGroup().getGroupNumber(), getCourse().getId()));
    }

    private int sequence;
    private CourseGroup group;
    private Course course;
    private int day;
    private int hour;
}
