/*
    Universidad Nacional de Costa Rica
    Escuela de Informática
    EIF209 Programación IV, ciclo I 2021
    Mauricio Gutiérrez Vásquez 118260119
    Adolfo Di Carlo Martínez Martínez 118050228
    Yeikol Villalobos Herrera 702670531
    Proyecto #1, Sistema web CursosLibres.com
*/

package model.dao.crud;

import cr.ac.una.db.dao.crud.AbstractCRUD;

public class UserAccountDataCRUD extends AbstractCRUD {

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
            + "id_usuario, rol_id, clave, ultimo_aceso, activo "
            + "FROM eif209_2021_01.usuario ORDER BY id_usuario; ";

    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.usuario "
            + "(id_usuario, rol_id, clave, ultimo_aceso, activo) "
            + "VALUES (?, ?, ?, ?, ?); ";

    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "id_usuario, rol_id, clave, ultimo_aceso, activo "
            + "FROM eif209_2021_01.usuario WHERE id_usuario = ?; ";

    protected static final String UPDATE_CMD
            = "UPDATE eif209_2021_01.usuario "
            + "SET id_usuario = ?, rol_id = ?, clave = ?, ultimo_aceso = ?, activo = ? "
            + "WHERE id_usuario = ?; ";

    protected static final String DELETE_CMD
            = "DELETE FROM eif209_2021_01.usuario "
            + "WHERE id_usuario = ?; ";
}
