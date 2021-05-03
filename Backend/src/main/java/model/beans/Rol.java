package model.beans;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "rol", propOrder = {"id", "description"})
public class Rol implements Serializable {

    public Rol(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Rol() {
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

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();

        return r.toString();
    }

    protected String toHTML() {
        StringBuilder r = new StringBuilder();

        return r.toString();
    }
    
    public String getHTML(){
        return toHTML();
    }

    private int id;
    private String description;

}
