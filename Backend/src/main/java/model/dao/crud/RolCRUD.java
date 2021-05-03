package model.dao.crud;

import cr.ac.una.db.dao.crud.AbstractCRUD;

public class RolCRUD extends AbstractCRUD {

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
            + "id_rol, descripcion "
            + "FROM eif209_2021_01.rol ORDER BY id_rol; ";

    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.rol "
            + "(id_rol, descripcion) "
            + "VALUES (?, ?); ";

    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "id_rol, descripcion "
            + "FROM eif209_2021_01.rol WHERE id_rol = ?; ";

    protected static final String UPDATE_CMD
            = "UPDATE eif209_2021_01.rol "
            + "SET descripcion = ? "
            + "WHERE id_rol = ?; ";

    protected static final String DELETE_CMD
            = "DELETE FROM eif209_2021_01.rol "
            + "WHERE id_rol = ?; ";

}