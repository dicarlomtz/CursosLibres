package model.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlType;
import model.dao.CourseGroupDAO;

@XmlType(name = "courseGroups")
public class SetCourseGroups extends Set<Integer, CourseGroup> {

    public SetCourseGroups() throws Exception {
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
    public CourseGroup retrieve(Integer id) throws Exception {
        return (CourseGroup) dao.retrieve(id);
    }

    @Override
    protected String toHTML() throws Exception {
        return null;
    }

    public List<CourseGroup> listAllProfessorId(int id) throws Exception {
        List<CourseGroup> groups = listAll();
        List<CourseGroup> groupsProfessor = new ArrayList<>();

        for (CourseGroup g : groups) {
            if (g.getProfessor().getId() == id) {
                groupsProfessor.add(g);
            }
        }

        return groupsProfessor;
    }

    protected String toHTMLAllProfessorGroups(int id) throws Exception {
        List<CourseGroup> groups = listAllProfessorId(id);
        StringBuilder r = new StringBuilder();
        for (CourseGroup g : groups) {
            r.append(g.getHTMLTableProfessor());
        }
        return r.toString();
    }

    public String getTableProfessorGroups(int id) throws Exception {
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
