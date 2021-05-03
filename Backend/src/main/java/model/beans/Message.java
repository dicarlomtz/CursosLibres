package model.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "message", propOrder = {"message"})
public class Message implements java.io.Serializable {

    public Message(String message) {
        this.message = message;
    }

    public Message() {
        this("");
    }

    public String getMessage() {
        return message;
    }

    @XmlElement(name = "message")
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String toString(){
        return message;
    }
    
    private String message;
    
}