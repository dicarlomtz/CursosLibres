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
