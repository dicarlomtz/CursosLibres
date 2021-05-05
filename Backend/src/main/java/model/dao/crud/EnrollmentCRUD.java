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

public class EnrollmentCRUD extends AbstractCRUD {

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
            + "estudiante_id, grupo_num, curso_id, estado_id, nota "
            + "FROM eif209_2021_01.matricula ORDER BY estudiante_id; ";

    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.matricula "
            + "(estudiante_id, grupo_num, curso_id, estado_id, nota) "
            + "VALUES (?, ?, ?, ?, ?); ";

    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "estudiante_id, grupo_num, curso_id, estado_id, nota "
            + "FROM eif209_2021_01.matricula WHERE estudiante_id = ? AND grupo_num = ? AND curso_id = ?; ";

    protected static final String UPDATE_CMD
            = "UPDATE eif209_2021_01.matricula "
            + "SET estado_id = ?, nota = ? "
            + "WHERE estudiante_id = ? AND grupo_num = ? AND curso_id = ?; ";

    protected static final String DELETE_CMD
            = "DELETE FROM eif209_2021_01.matricula "
            + "WHERE estudiante_id = ? AND grupo_num = ? AND curso_id = ?; ";
}
