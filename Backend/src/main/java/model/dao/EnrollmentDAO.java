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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.beans.Enrollment;
import model.dao.crud.EnrollmentCRUD;

public class EnrollmentDAO extends AbstractDAO<String, Enrollment> {

    public EnrollmentDAO() throws IOException {
        super(new DaoDB(), new EnrollmentCRUD());
    }

    @Override
    public Enrollment retrieve(String id)
            throws SQLException, IOException {
        Enrollment r = null;
        String[] parameters = id.split("-");
        int index = 1;
        try (Connection cnx = db.getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getRetrieveCmd())) {
            stm.clearParameters();
            for (String parameter : parameters) {
                stm.setInt(index++, Integer.parseInt(parameter));
            }
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = getRecord(rs);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return r;
    }

    @Override
    public Enrollment getRecord(ResultSet rs)
            throws SQLException, IOException {
        return new Enrollment(
                new StudentDAO().retrieve(rs.getInt("estudiante_id")),
                new CourseGroupDAO().retrieve(rs.getInt("grupo_num")),
                new CourseDAO().retrieve(rs.getInt("curso_id")),
                new ConditionDAO().retrieve(rs.getInt("estado_id")),
                rs.getInt("nota")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            String id, Enrollment value)
            throws SQLException {
        stm.setInt(1, Integer.parseInt(id));
        stm.setInt(2, value.getGroup().getGroupNumber());
        stm.setInt(3, value.getCourse().getId());
        stm.setInt(4, value.getCondition().getId());
        stm.setInt(5, value.getGrade());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            String id, Enrollment value)
            throws SQLException {
        String[] parameters = id.split("-");
        int index = 3;
        stm.setInt(1, value.getCondition().getId());
        stm.setInt(2, value.getGrade());
        for (String parameter : parameters) {
            stm.setInt(index++, Integer.parseInt(parameter));
        }
    }

    @Override
    public void delete(String id) 
            throws SQLException, IOException {
        String[] parameters = id.split("-");
        int index = 1;
        try (Connection cnx = db.getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getDeleteCmd())) {
            stm.clearParameters();
            for (String parameter : parameters) {
                stm.setInt(index++, Integer.parseInt(parameter));
            }
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }
}
