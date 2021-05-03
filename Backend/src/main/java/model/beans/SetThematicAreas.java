package model.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.ThematicAreaDAO;

public class SetThematicAreas extends Set<Integer, ThematicArea> {

    public SetThematicAreas() throws Exception {
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
    public ThematicArea retrieve(Integer id) throws Exception {
        return (ThematicArea) dao.retrieve(id);
    }

    @Override
    protected String toHTML() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    protected String toHTMLProfessorOption() throws Exception {
        StringBuilder r = new StringBuilder();
        List<ThematicArea> list = listAll();

        for (ThematicArea ta : list) {
            r.append(ta.getHTMLProfessorSpecialityOption());
        }

        return r.toString();
    }

    public String getHTMLProfessorOption() throws Exception {
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

    protected String toHTMLThematicAreas() throws Exception {
        List<ThematicArea> list = listAll();
        StringBuilder r = new StringBuilder();

        for (ThematicArea t : list) {
            r.append(t.getHTMLThematicAreaChangeOption());
        }

        return r.toString();
    }

    public String getHTMLThematicAreas() throws Exception {
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
