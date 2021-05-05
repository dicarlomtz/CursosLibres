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
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import model.DateAdapter;

@XmlType(name = "userAccountData", propOrder = {"id", "rol", "password", "lastAccess", "active"})
public class UserAccountData implements Serializable {

    public UserAccountData(String id, Rol rol, String password, Date lastAccess, boolean active) {
        this.id = id;
        this.rol = rol;
        this.password = password;
        this.lastAccess = lastAccess;
        this.active = active;
    }

    public UserAccountData() {
    }

    public String getId() {
        return id;
    }

    @XmlElement(name = "id")
    public void setId(String id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    @XmlElement(name = "rol")
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement(name = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    @XmlElement(name = "lastAccess")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    public boolean isActive() {
        return active;
    }

    @XmlElement(name = "active")
    public void setActive(boolean active) {
        this.active = active;
    }

    public String generateCompoundIdentifier() {
        return String.format("%d%d", getId(), getRol().getId());
    }

    private String id;
    private Rol rol;
    private String password;
    private Date lastAccess;
    private boolean active;
}
