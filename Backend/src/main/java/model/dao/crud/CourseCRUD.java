package model.dao.crud;

import cr.ac.una.db.dao.crud.AbstractCRUD;

public class CourseCRUD extends AbstractCRUD {

    @Override
    public String getListAllCmd() {
        return LIST_CMD;
    }

    @Override
    public String getAddCmd() {
        return ADD_CMD;
    }

    @Override
    public String getRetrieveCmd() {
        return RETRIEVE_CMD;
    }

    @Override
    public String getUpdateCmd() {
        return UPDATE_CMD;
    }

    @Override
    public String getDeleteCmd() {
        return DELETE_CMD;
    }

    protected static final String LIST_CMD
            = "SELECT "
            + "id_curso, descripcion, area_tematica_id "
            + "FROM eif209_2021_01.curso ORDER BY id_curso; ";

    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.curso "
            + "(id_curso, descripcion, area_tematica_id) "
            + "VALUES (?, ?, ?); ";

    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "id_curso, descripcion, area_tematica_id "
            + "FROM eif209_2021_01.curso WHERE id_curso = ?; ";

    protected static final String UPDATE_CMD
            = "UPDATE eif209_2021_01.curso "
            + "SET area_tematica_id = ?, descripcion = ? "
            + "WHERE id_curso = ?; ";

    protected static final String DELETE_CMD
            = "DELETE FROM eif209_2021_01.curso "
            + "WHERE id_curso = ?; ";
}
