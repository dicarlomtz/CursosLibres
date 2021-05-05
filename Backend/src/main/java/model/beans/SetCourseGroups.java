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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import model.dao.CourseGroupDAO;

@XmlType(name = "courseGroups")
public class SetCourseGroups extends Set<Integer, CourseGroup> {

    public SetCourseGroups() throws IOException {
        super(new CourseGroupDAO());
    }

    @Override
    public void add(CourseGroup item) throws SQLException, IOException {
        dao.add(item.getGroupNumber(), item);
    }

    @Override
    public void update(CourseGroup item) throws SQLException, IOException {
        dao.update(item.getGroupNumber(), item);
    }

    @Override
    public CourseGroup retrieve(Integer id) throws SQLException, IOException {
        return (CourseGroup) dao.retrieve(id);
    }

    @Override
    protected String toHTML() throws SQLException, IOException {
        return null;
    }

    public List<CourseGroup> listAllProfessorId(int id) throws SQLException, IOException {
        List<CourseGroup> groups = listAll();
        List<CourseGroup> groupsProfessor = new ArrayList<>();

        for (CourseGroup g : groups) {
            if (g.getProfessor().getId() == id) {
                groupsProfessor.add(g);
            }
        }

        return groupsProfessor;
    }

    protected String toHTMLAllProfessorGroups(int id) throws SQLException, IOException {
        List<CourseGroup> groups = listAllProfessorId(id);
        StringBuilder r = new StringBuilder();
        for (CourseGroup g : groups) {
            r.append(g.getHTMLTableProfessor());
        }
        return r.toString();
    }

    public String getTableProfessorGroups(int id) throws SQLException, IOException {
        return toHTMLAllProfessorGroups(id);
    }
    
    public static String getTableProfessorGroupsStatic(GenericUser user){
        try {
            return new SetCourseGroups().getTableProfessorGroups(user.getId());
        } catch (Exception ex) {
         
        }
        return "";
    }
}
