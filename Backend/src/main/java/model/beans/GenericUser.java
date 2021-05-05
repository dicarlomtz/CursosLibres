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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "genericUser", propOrder = {"id", "user", "lastName1", "lastName2", "name", "telephoneNumber"})
public class GenericUser implements Serializable {

    public GenericUser(int id, UserAccountData accData, String lastName1, String lastName2, String name, int telephoneNumber, String email) {
        this.id = id;
        this.accData = accData;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public GenericUser() {
        this(0, new UserAccountData(), null, null, null, 0, null);
    }

    public int getId() {
        return id;
    }

    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public UserAccountData getAccData() {
        return accData;
    }

    @XmlElement(name = "accountData")
    public void setAccData(UserAccountData accData) {
        this.accData = accData;
    }

    public String getLastName1() {
        return lastName1;
    }

    @XmlElement(name = "lastName1")
    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    @XmlElement(name = "lastName2")
    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    @XmlElement(name = "telephoneNumber")
    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement(name = "name")
    public void setEmail(String email) {
        this.email = email;
    }

    protected String toHTMLInformation() {
        StringBuilder r = new StringBuilder();

        r.append("<h2>Datos de usuario</h2>\n");
        r.append(String.format("<span><p>Identificación: %d</p></span>", getId()));
        r.append(String.format("<span><p>Nombre: %s %s %s</p></span>", getName(), getLastName1(), getLastName2()));
        r.append(String.format("<span><p>E-mail: %s</p></span>", getEmail()));
        r.append(String.format("<span><p>Teléfono: %d</p></span>", getTelephoneNumber()));

        return r.toString();
    }
    
    public String getHTMLInformation() {
        return toHTMLInformation();
    }

    public static String getCompleteName(GenericUser user)
    {
        return user.getLastName1() + " " + user.getLastName2() + ", " + user.getName();
    }
    
    public static String getHTMLInformation(GenericUser user) {
        return user.getHTMLInformation();
    }

    protected String toHTMLTable() {
        StringBuilder r = new StringBuilder();

        r.append("<tr>");
        r.append(String.format("<td>Identificación:%d</td>", getId()));
        r.append(String.format("<td>Nombre:%s %s %s</td>", getName(), getLastName1(), getLastName2()));
        r.append(String.format("<td>E-mail:%s</td>", getEmail()));
        r.append(String.format("<td>Teléfono: %d</td>", getTelephoneNumber()));
        r.append("</tr>");

        return r.toString();
    }

    public String getHTMLTable() {
        return toHTMLTable();
    }

    private int id;
    private UserAccountData accData;
    private String lastName1;
    private String lastName2;
    private String name;
    private int telephoneNumber;
    private String email;
}
