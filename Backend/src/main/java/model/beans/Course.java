package model.beans;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "course", propOrder = {"id", "description", "thematicArea"})
public class Course implements Serializable {

    public Course(int id, String description, ThematicArea thematicArea) {
        this.id = id;
        this.description = description;
        this.thematicArea = thematicArea;
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
    
    protected String toHTMLTable() {
        StringBuilder r = new StringBuilder();

        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<td>%d</td>\n", this.getId()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", this.getDescription()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", this.getThematicArea().getDescription()));
        r.append(String.format("\t\t\t\t<td><form action=\"SchedulesService\"><button class=\"button\" name=\"courseSchedules\" value=\"%d\">%s</button></form></td>\n", this.getId(), "Ver horario"));
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
        r.append(String.format("\t\t\t\t<td><form action=\"SchedulesAdminService\"><button class=\"button\" name=\"courseSchedules\" value=\"%s\">%s</button></form></td>\n", this.getId(), "Ver horario"));
        r.append(String.format("\t\t\t\t<td><form action=\"CourseGroupRegisterService\" method=\"GET\"><button class=\"button\" name=\"idCourse\" value=\"%d\">%s</button></form></td>", this.getId(), "Abrir grupos"));
        r.append(String.format("\t\t\t\t<td><form action=\"ModifyCourseService\" method=\"GET\"><button class=\"button\" name=\"idCourseM\" value=\"%d\">%s</button></form></td>", this.getId(), "Modificar"));
        r.append("\t\t\t</tr>\n");
        
        return r.toString();
    }
    
    public String getHTMLTableAdmin() {
        return toHTMLTableAdmin();
    }
    
    public String toHTMLModify() throws Exception
    {
        StringBuilder r = new StringBuilder();
        
        r.append("<form action=\"EditCourseService\" method=\"GET\">");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<td>%d</td>\n", this.getId()));
        r.append(String.format("\t\t\t\t<td><input name=\"courseDescription\" value=\"%s\"></input></td>\n", this.getDescription()));
        r.append(String.format("\t\t\t\t<td><select name=\"thematicArea\">"));
        r.append(new SetThematicAreas().getHTMLThematicAreas());
        r.append(String.format("</select></td>\n"));
        r.append(String.format("\t\t\t\t<td><button class =\"button\" name=\"idCourseM\" value=\"%d\">%s</button></td>\n", this.getId(),"Modificar"));
        r.append("\t\t\t</tr>\n");
        r.append("</form>");
        
        return r.toString();
    }
    
    public String getHTMLModify() throws Exception{
        return toHTMLModify();
    }
    
    private int id;
    private String description;
    private ThematicArea thematicArea;
}
