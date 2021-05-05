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
import model.beans.Speciality;
import model.dao.crud.SpecialityCRUD;

public class SpecialityDAO extends AbstractDAO<Integer, Speciality> {
    
    public SpecialityDAO() throws IOException {
        super(new DaoDB(), new SpecialityCRUD());
    }

    @Override
    public Speciality getRecord(ResultSet rs)
            throws SQLException, IOException {
            return new Speciality(
                    new ProfessorDAO().retrieve(rs.getInt("profesor_id_profesor")),
                    new ThematicAreaDAO().retrieve(rs.getInt("area_tematica_id"))
            );
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Speciality value)
            throws SQLException {
        stm.setInt(1, id);
        stm.setInt(2, value.getThematicArea().getId());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Speciality value)
            throws SQLException {
        stm.setInt(1, value.getThematicArea().getId());
        stm.setInt(2, id);
    }
}
