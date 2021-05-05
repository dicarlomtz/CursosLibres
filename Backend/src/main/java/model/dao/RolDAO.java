/*
    Universidad Nacional de Costa Rica
    Escuela de Informática
    EIF209 Programación IV, ciclo I 2021
    Mauricio Gutiérrez Vásquez 118260119
    Adolfo Di Carlo Martínez Martínez 118050228
    Yeikol Villalobos Herrera 702670531
    Proyecto #1, Sistema web CursosLibres.com
*/

package model.dao;

import cr.ac.una.db.dao.AbstractDAO;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.beans.Rol;
import model.dao.crud.RolCRUD;

public class RolDAO extends AbstractDAO<Integer, Rol> {
    
       public RolDAO() throws IOException {
        super(new DaoDB(), new RolCRUD());
    }

    @Override
    public Rol getRecord(ResultSet rs)
            throws SQLException, IOException {
        return new Rol(
                rs.getInt("id_rol"),
                rs.getString("descripcion")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Rol value)
            throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, value.getDescription());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Rol value)
            throws SQLException {
        stm.setString(1, value.getDescription());
        stm.setInt(2, id);
    }
}

