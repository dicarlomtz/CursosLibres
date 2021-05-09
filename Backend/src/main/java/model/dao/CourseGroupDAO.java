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
import model.beans.CourseGroup;
import model.dao.crud.CourseGroupCRUD;

public class CourseGroupDAO extends AbstractDAO<Integer, CourseGroup> {

    public CourseGroupDAO() throws IOException {
        super(new DaoDB(), new CourseGroupCRUD());
    }

    @Override
    public CourseGroup getRecord(ResultSet rs)
            throws SQLException, IOException {
        return new CourseGroup(
                rs.getInt("num_grupo"),
                new CourseDAO().retrieve(rs.getInt("curso_id")),
                new ProfessorDAO().retrieve(rs.getInt("profesor_id")),
                rs.getBoolean("promocion")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, CourseGroup value)
            throws SQLException {
        stm.setInt(1, id);
        stm.setInt(2, value.getCourse().getId());
        stm.setInt(3, value.getProfessor().getId());
        stm.setBoolean(4, value.getPromotion());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, CourseGroup value)
            throws SQLException {
        stm.setInt(1, value.getCourse().getId());
        stm.setInt(2, value.getProfessor().getId());
        stm.setBoolean(3, value.getPromotion());
        stm.setInt(4, id);

    }
}
