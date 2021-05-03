package model.dao;

import cr.ac.una.db.dao.AbstractDAO;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.beans.ThematicArea;
import model.dao.crud.ThematicAreaCRUD;

public class ThematicAreaDAO extends AbstractDAO<Integer, ThematicArea> {

    public ThematicAreaDAO() throws IOException {
        super(new DaoDB(), new ThematicAreaCRUD());
    }

    @Override
    public ThematicArea getRecord(ResultSet rs)
            throws SQLException, IOException {
        return new ThematicArea(
                rs.getInt("id_area"),
                rs.getString("descripcion")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, ThematicArea value)
            throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, value.getDescription());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, ThematicArea value)
            throws SQLException {
        stm.setString(1, value.getDescription());
        stm.setInt(2, id);
    }

}
