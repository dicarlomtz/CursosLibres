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
import model.beans.UserAccountData;
import model.dao.crud.UserAccountDataCRUD;

public class UserAccountDataDAO extends AbstractDAO<String, UserAccountData> {

    public UserAccountDataDAO() throws IOException {
        super(new DaoDB(), new UserAccountDataCRUD());
    }

    @Override
    public UserAccountData getRecord(ResultSet rs)
            throws SQLException, IOException {
        return new UserAccountData(
                rs.getString("id_usuario"),
                new RolDAO().retrieve(rs.getInt("rol_id")),
                rs.getString("clave"),
                new java.util.Date(rs.getDate("ultimo_aceso").getTime()),
                rs.getBoolean("activo")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            String id, UserAccountData value)
            throws SQLException {
        stm.setString(1, id);
        stm.setInt(2, value.getRol().getId());
        stm.setString(3, value.getPassword());
        stm.setDate(4, new java.sql.Date(value.getLastAccess().getTime()));
        stm.setBoolean(5, value.isActive());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            String id, UserAccountData value)
            throws SQLException {
        stm.setString(1, value.getId());
        stm.setInt(2, value.getRol().getId());
        stm.setString(3, value.getPassword());
        stm.setDate(4, new java.sql.Date(value.getLastAccess().getTime()));
        stm.setBoolean(5, value.isActive());
        stm.setString(6, id);
    }
}
