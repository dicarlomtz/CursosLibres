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

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "course", propOrder = {"id", "description", "thematicArea", "promotion"})
public class Course implements Serializable {

    public Course(int id, String description, ThematicArea thematicArea, boolean promotion) {
        this.id = id;
        this.description = description;
        this.thematicArea = thematicArea;
        this.promotion = promotion;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }

    public ThematicArea getThematicArea() {
        return thematicArea;
    }

    @XmlElement(name = "thematicArea")
    public void setThematicArea(ThematicArea thematicArea) {
        this.thematicArea = thematicArea;
    }
    
    public boolean getPromotion()
    {
        return this.promotion;
    }
    
    @XmlElement(name = "promotion")
    public void setPromotion(boolean promotion)
    {
        this.promotion = promotion;
    }
    
    protected String toHTMLTable() {
        StringBuilder r = new StringBuilder();

        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<td>%d</td>\n", this.getId()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", this.getDescription()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", this.getThematicArea().getDescription()));
        r.append(String.format("\t\t\t\t<td><form action=\"SchedulesService\" method=\"POST\"><button class=\"bn-table\" name=\"courseSchedules\" value=\"%d\">%s</button></form></td>\n", this.getId(), "Ver horario"));
        r.append("\t\t\t</tr>\n");
        
        return r.toString();
    }
    
    public String getHTMLTable() {
        return toHTMLTable();
    }
    
    protected String toHTMLTableAdmin() {
         StringBuilder r = new StringBuilder();

        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<td>%d</td>\n", this.getId()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", this.getDescription()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", this.getThematicArea().getDescription()));
        r.append(String.format("\t\t\t\t<td><form action=\"SchedulesAdminService\" method=\"POST\"><button class=\"bn-table\" name=\"courseSchedules\" value=\"%s\">%s</button></form></td>\n", this.getId(), "Ver horario"));
        r.append(String.format("\t\t\t\t<td><form action=\"CourseGroupRegisterService\" method=\"POST\"><button class=\"bn-table\" name=\"idCourse\" value=\"%d\">%s</button></form></td>", this.getId(), "Abrir grupos"));
        r.append(String.format("\t\t\t\t<td><form action=\"ModifyCourseService\" method=\"POST\"><button class=\"bn-table\" name=\"idCourseM\" value=\"%d\">%s</button></form></td>", this.getId(), "Modificar"));
        r.append("\t\t\t</tr>\n");
        
        return r.toString();
    }
    
    public String getHTMLTableAdmin() {
        return toHTMLTableAdmin();
    }
    
    public String toHTMLModify() throws IOException, SQLException
    {
        StringBuilder r = new StringBuilder();
        
        r.append("<form action=\"EditCourseService\" method=\"GET\">");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<td>%d</td>\n", this.getId()));
        r.append(String.format("\t\t\t\t<td><input class=\"input-form\" styles=\"height: 30px;\" name=\"courseDescription\" type=\"text\" value=\"%s\" title=\"%s\" required></input></td>\n", this.getDescription(), "Debe llenar todos los espacios"));
        r.append(String.format("\t\t\t\t<td><select name=\"thematicArea\">"));
        r.append(new SetThematicAreas().getHTMLThematicAreas());
        r.append(String.format("\t\t\t\t</select></td>\n"));
        r.append(String.format("\t\t\t\t<td><select name=\"promotion\">"));
        r.append(String.format("<option value=\"True\">%s</option>", "En promoción"));
        r.append(String.format("<option value=\"yes\">%s</option>", "Revocar promoción"));
        r.append(String.format("\t\t\t\t</select></td>\n"));
        r.append(String.format("\t\t\t\t<td><button class=\"bn-table\" name=\"idCourseM\" value=\"%d\">%s</button></td>\n", this.getId(), "Modificar"));
        r.append("\t\t\t</tr>\n");
        r.append("</form>");
        
        return r.toString();
    }
    
    public String getHTMLModify() throws IOException, SQLException{
        return toHTMLModify();
    }
    
    private int id;
    private String description;
    private ThematicArea thematicArea;
    private boolean promotion;
}
