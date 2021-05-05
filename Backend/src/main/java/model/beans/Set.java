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

import cr.ac.una.db.dao.AbstractDAO;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "groupableList")
public abstract class Set<Key, Type> implements Serializable {

    public Set(AbstractDAO dao) {
        this.dao = dao;
    }

    public List<Type> listAll() throws SQLException, IOException {
        return dao.listAll();
    }

    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    public String getTable() throws SQLException, IOException {
        return toHTML();
    }

    public abstract void add(Type item) throws SQLException, IOException;

    public abstract void update(Type item) throws SQLException, IOException;

    public abstract Type retrieve(Key id) throws SQLException, IOException;
    
    protected abstract String toHTML() throws SQLException, IOException;

    @XmlTransient
    protected AbstractDAO dao;
}
