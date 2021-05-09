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
import model.beans.Course;
import model.dao.crud.CourseCRUD;

public class CourseDAO extends AbstractDAO<Integer, Course> {

    public CourseDAO() throws IOException {
        super(new DaoDB(), new CourseCRUD());
    }

    @Override
    public Course getRecord(ResultSet rs)
            throws SQLException, IOException {
        return new Course(rs.getInt("id_curso"),
                rs.getString("descripcion"),
                new ThematicAreaDAO().retrieve(rs.getInt("area_tematica_id")),
                rs.getBoolean("promocion"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Course value)
            throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, value.getDescription());
        stm.setInt(3, value.getThematicArea().getId());
        stm.setBoolean(4, value.getPromotion());

    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Course value)
            throws SQLException {
        stm.setInt(1, value.getThematicArea().getId());
        stm.setString(2, value.getDescription());
        stm.setBoolean(3, value.getPromotion());
        stm.setInt(4, id);

    }
}
