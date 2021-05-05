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
import java.sql.SQLException;
import java.sql.ResultSet;
import model.beans.Schedule;
import model.dao.crud.ScheduleCRUD;

public class ScheduleDAO extends AbstractDAO<Integer, Schedule> {

    public ScheduleDAO() throws IOException {
        super(new DaoDB(), new ScheduleCRUD());
    }

    @Override
    public Schedule getRecord(ResultSet rs)
            throws SQLException, IOException {

        return new Schedule(
                rs.getInt("seq"),
                new CourseGroupDAO().retrieve(rs.getInt("grupo_num")),
                new CourseDAO().retrieve(rs.getInt("grupo_curso_id")),
                rs.getInt("dia"),
                rs.getInt("hora")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Schedule value)
            throws SQLException {
        stm.setInt(1, value.getGroup().getGroupNumber());
        stm.setInt(2, value.getCourse().getId());
        stm.setInt(3, value.getDay());
        stm.setInt(4, value.getHour());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer seq, Schedule value)
            throws SQLException {
        stm.setInt(1, value.getGroup().getGroupNumber());
        stm.setInt(2, value.getCourse().getId());
        stm.setInt(3, value.getDay());
        stm.setInt(4, value.getHour());
        stm.setInt(5, seq);
    }
}
