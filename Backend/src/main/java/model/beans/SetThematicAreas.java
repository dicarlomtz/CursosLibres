/*
    Universidad Nacional de Costa Rica
    Escuela de Informática
    EIF209 Programación IV, ciclo I 2021
    Mauricio Gutiérrez Vásquez 118260119
    Adolfo Di Carlo Martínez Martínez 118050228
    Yeikol Villalobos Herrera 702670531
    Proyecto #1, Sistema web CursosLibres.com
*/

package model.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.ThematicAreaDAO;

public class SetThematicAreas extends Set<Integer, ThematicArea> {

    public SetThematicAreas() throws IOException {
        super(new ThematicAreaDAO());
    }

    @Override
    public void add(ThematicArea item) throws SQLException, IOException {
        dao.add(item.getId(), item);
    }

    @Override
    public void update(ThematicArea item) throws SQLException, IOException {
        dao.update(item.getId(), item);
    }

    @Override
    public ThematicArea retrieve(Integer id) throws SQLException, IOException {
        return (ThematicArea) dao.retrieve(id);
    }

    @Override
    protected String toHTML() throws SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    protected String toHTMLProfessorOption() throws SQLException, IOException {
        StringBuilder r = new StringBuilder();
        List<ThematicArea> list = listAll();

        if (list.isEmpty()) {
            r.append("<p>No hay especialidades disponibles</p>");
        }

        for (ThematicArea ta : list) {
            r.append(ta.getHTMLProfessorSpecialityOption());
        }

        return r.toString();
    }

    public String getHTMLProfessorOption() throws SQLException, IOException {
        return toHTMLProfessorOption();
    }

    public static String getHTMLProfessorOptionStatic() {
        try {
            return new SetThematicAreas().getHTMLProfessorOption();
        } catch (Exception ex) {
            Logger.getLogger(SetThematicAreas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    protected String toHTMLThematicAreas() throws SQLException, IOException {
        List<ThematicArea> list = listAll();
        StringBuilder r = new StringBuilder();

        for (ThematicArea t : list) {
            r.append(t.getHTMLThematicAreaChangeOption());
        }

        return r.toString();
    }

    public String getHTMLThematicAreas() throws SQLException, IOException {
        return toHTMLThematicAreas();
    }

    public static String getHTMLThematicAreasStatic() {
        try {
            return new SetThematicAreas().getHTMLThematicAreas();
        } catch (Exception ex) {

        }
        return "";
    }
}
