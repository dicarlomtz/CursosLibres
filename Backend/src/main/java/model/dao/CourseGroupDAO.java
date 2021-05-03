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
                new ProfessorDAO().retrieve(rs.getInt("profesor_id"))
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, CourseGroup value)
            throws SQLException {
        stm.setInt(1, id);
        stm.setInt(2, value.getCourse().getId());
        stm.setInt(3, value.getProfessor().getId());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, CourseGroup value)
            throws SQLException {
        stm.setInt(1, value.getCourse().getId());
        stm.setInt(2, value.getProfessor().getId());
        stm.setInt(3, id);
    }

}
