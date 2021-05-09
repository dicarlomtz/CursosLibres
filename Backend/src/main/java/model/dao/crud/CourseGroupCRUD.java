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

public class CourseGroupCRUD extends AbstractCRUD {

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
            + "num_grupo, curso_id, profesor_id, promocion "
            + "FROM eif209_2021_01.grupo ORDER BY num_grupo; ";

    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.grupo "
            + "(num_grupo, curso_id, profesor_id, promocion) "
            + "VALUES (?, ?, ?, ?); ";

    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "num_grupo, curso_id, profesor_id, promocion "
            + "FROM eif209_2021_01.grupo WHERE num_grupo = ?; ";

    protected static final String UPDATE_CMD
            = "UPDATE eif209_2021_01.grupo "
            + "SET curso_id = ?, profesor_id = ?, promocion = ? "
            + "WHERE num_grupo = ?; ";

    protected static final String DELETE_CMD
            = "DELETE FROM eif209_2021_01.grupo "
            + "WHERE num_grupo = ?; ";
}
