package model.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlType;
import model.dao.ProfessorDAO;

@XmlType(name = "professors")
public class SetProfessors extends Set<Integer, Professor> {

    public SetProfessors() throws IOException {
        super(new ProfessorDAO());
    }

    @Override
    public void add(Professor item) throws SQLException, IOException {
        dao.add(item.getId(), item);
    }

    @Override
    public void update(Professor item) throws SQLException, IOException {
        dao.update(item.getId(), item);
    }

    @Override
    public Professor retrieve(Integer id) throws SQLException, IOException {
        return (Professor) dao.retrieve(id);
    }

    @Override
    protected String toHTML() throws SQLException, IOException {
        StringBuilder r = new StringBuilder();

        List<Professor> list = listAll();

        for (Professor p : list) {
            r.append(p.getHTMLTable());
        }

        return r.toString();
    }

    public String getTableProfessors() throws SQLException, IOException {
        return toHTML();
    }

    public static String getTableStatic() {
        try {
            return new SetProfessors().getTableProfessors();
        } catch (Exception ex) {

        }
        return "";
    }

}
