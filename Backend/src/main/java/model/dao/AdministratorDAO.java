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
import model.beans.Administrator;
import model.dao.crud.AdministratorCRUD;

public class AdministratorDAO extends AbstractDAO<Integer, Administrator> {

    public AdministratorDAO() throws IOException {
        super(new DaoDB(), new AdministratorCRUD());
    }

    @Override
    public Administrator getRecord(ResultSet rs)
            throws SQLException, IOException {
            return new Administrator(
                    rs.getInt("id_administrador"),
                    new UserAccountDataDAO().retrieve(rs.getString("usuario_id")),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("nombre"),
                    rs.getInt("telefono"),
                    rs.getString("e_mail")
            );
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Administrator value)
            throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, value.getAccData().getId());
        stm.setString(3, value.getLastName1());
        stm.setString(4, value.getLastName2());
        stm.setString(5, value.getName());
        stm.setInt(6, value.getTelephoneNumber());
        stm.setString(7, value.getEmail());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Administrator value)
            throws SQLException {
        stm.setString(1, value.getAccData().getId());
        stm.setString(2, value.getLastName1());
        stm.setString(3, value.getLastName2());
        stm.setString(4, value.getName());
        stm.setInt(5, value.getTelephoneNumber());
        stm.setString(6, value.getEmail());
        stm.setInt(7, id);
    }
}
