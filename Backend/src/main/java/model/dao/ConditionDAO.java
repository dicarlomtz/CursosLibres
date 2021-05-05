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
import model.beans.Condition;
import model.dao.crud.ConditionCRUD;

public class ConditionDAO extends AbstractDAO<Integer, Condition> {

    public ConditionDAO() throws IOException {
        super(new DaoDB(), new ConditionCRUD());
    }

    @Override
    public Condition getRecord(ResultSet rs) 
            throws SQLException, IOException {
        return new Condition(
                rs.getInt("id_estado"),
                rs.getString("descripcion")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Condition value)
            throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, value.getDescription());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Condition value)
            throws SQLException {
        stm.setString(1, value.getDescription());
        stm.setInt(2, id);
    }
}
