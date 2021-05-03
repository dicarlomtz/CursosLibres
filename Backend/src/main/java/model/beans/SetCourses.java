package model.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import model.dao.CourseDAO;

@XmlType(name = "course")
public class SetCourses extends Set<Integer, Course> {

    public SetCourses() throws Exception {
        super(new CourseDAO());
    }

    @Override
    public void add(Course item) throws SQLException, IOException {
        dao.add(item.getId(), item);
    }

    @Override
    public void update(Course item) throws SQLException, IOException {
        dao.update(item.getId(), item);
    }

    @Override
    public Course retrieve(Integer id) throws Exception {
        return (Course) dao.retrieve(id);
    }

    @Override
    protected String toHTML() throws Exception {
        return null;
    }

    public List<Course> listAllCourses(String filter) throws Exception {
        List<Course> courses = listAll();
        List<Course> coursesFilter = new ArrayList<>();

        for (Course c : courses) {
            if (c.getDescription().toLowerCase().contains(filter.toLowerCase()) | 
                    c.getThematicArea().getDescription().toLowerCase().contains(filter.toLowerCase())) {
                coursesFilter.add(c);
            }
        }

        return coursesFilter;
    }

    protected String toHTMLAllCourses(String filter) throws Exception {
        List<Course> courses = listAllCourses(filter);
        StringBuilder r = new StringBuilder();

        for (Course c : courses) {
            r.append(c.getHTMLTable());
        }

        return r.toString();
    }

    public String getTableAllCourses(String filter) throws Exception {
        return toHTMLAllCourses(filter);
    }

    public static String getTableCourses(String filter) {
        try {
            return new SetCourses().getTableAllCourses(filter);
        } catch (Exception ex) {

        }
        return "";
    }

    protected String toHTMLAllCoursesAdmin(String filter) throws Exception {
        List<Course> courses = listAllCourses(filter);
        StringBuilder r = new StringBuilder();

        for (Course c : courses) {
            r.append(c.getHTMLTableAdmin());
        }

        return r.toString();
    }

    public String getTableAllCoursesAdmin(String filter) throws Exception {
        return toHTMLAllCoursesAdmin(filter);
    }

    public static String getTableCoursesAdmin(String filter) {
        try {
            return new SetCourses().getTableAllCoursesAdmin(filter);
        } catch (Exception ex) {

        }
        return "";
    }

    public String toHTMLSpecificCourse(int id) throws Exception {
        StringBuilder r = new StringBuilder();
        Course course = retrieve(id);

        r.append(course.getHTMLModify());

        return r.toString();
    }
    
    public static String getSpecificCourse(String id) {

        try {
            return new SetCourses().toHTMLSpecificCourse(Integer.parseInt(id));
        } catch (Exception ex) {
            
        }
        return "";
    }

}
