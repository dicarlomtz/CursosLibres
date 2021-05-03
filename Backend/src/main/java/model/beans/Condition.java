package model.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "condition", propOrder = {"id", "description"})
public class Condition implements java.io.Serializable {

    public Condition(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Condition() {
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

    @XmlElement(name = "descripion")
    public void setDescription(String description) {
        this.description = description;
    }

    private int id;
    private String description;

}
