package model.beans;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "thematicArea", propOrder = {"id", "description"})
public class ThematicArea implements Serializable {

    public ThematicArea(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public ThematicArea() {
    }

    public int getId() {
        return id;
    }

    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected String toHTMLProfessorSpecialityOption() {
        StringBuilder r = new StringBuilder();

        r.append(String.format("<input type=\"checkbox\" id=\"%s\"name=\"%s\" value=\"%d\">", getDescription(), getDescription(), getId()));
        r.append(String.format("<label for=\"%s\"> %s </label><br>", getDescription(), getDescription()));

        return r.toString();
    }

    public String getHTMLProfessorSpecialityOption() {
        return toHTMLProfessorSpecialityOption();
    }

    protected String toHTMLThematicAreaChangeOption() {
        StringBuilder r = new StringBuilder();

        r.append(String.format("<option value=\"%d\">%s</option>", getId(), getDescription()));

        return r.toString();
    }

    public String getHTMLThematicAreaChangeOption() {
        return toHTMLThematicAreaChangeOption();
    }

    private int id;
    private String description;
}
