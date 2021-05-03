package model.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlType;
import model.dao.EnrollmentDAO;

@XmlType(name = "enrollments")
public class SetEnrollments extends Set<String, Enrollment> {

    public SetEnrollments() throws Exception {
        super(new EnrollmentDAO());
    }

    @Override
    public void add(Enrollment item) throws SQLException, IOException {
        dao.add(String.valueOf(item.getStudent().getId()), item);
    }

    @Override
    public void update(Enrollment item) throws SQLException, IOException {
        dao.update(item.generateCompoundIdentifier(), item);
    }

    @Override
    public Enrollment retrieve(String id) throws Exception {
        return (Enrollment) dao.retrieve(id);
    }

     @Override
    protected String toHTML() throws Exception {
       return null;
    }

    public List<Enrollment> listAllGroupNumber(int groupNumber) throws Exception {
        List<Enrollment> enrollments = listAll();
        List<Enrollment> enrollmentGroupsNumber = new ArrayList<>();

        for (Enrollment e : enrollments) {
            if (e.getGroup().getGroupNumber() == groupNumber) {
                enrollmentGroupsNumber.add(e);
            }
        }
        return enrollmentGroupsNumber;
    }

    public String toHTMLAllGroupNumber(int groupNumber) throws Exception {
        List<Enrollment> enrollments = listAllGroupNumber(groupNumber);
        StringBuilder r = new StringBuilder();
        for(Enrollment e : enrollments) {
            r.append(e.getHTMLTableAssignGrades());
        }
        
        return r.toString();
    }
    
    public String getTableGroupNumber(int groupNumber) throws Exception {
        return toHTMLAllGroupNumber(groupNumber);
    }
    
    public static String getTableGroupNumber(CourseGroup g) {
        try {
            return new SetEnrollments().getTableGroupNumber(g.getGroupNumber());
        } catch (Exception ex) {
            
        }
        return "";
    }
 
    public List<Enrollment> getListStudentEnrollments(int id) throws Exception
    {
        List<Enrollment> enrollments = listAll();
        List<Enrollment> aux = new ArrayList<>();
        
        for(Enrollment e : enrollments)
        {
            if(e.getStudent().getId() == id)
            {
                aux.add(e);
            }
        }
        
        return aux;
    }
    
    protected String toHTMLStudentEnrollments(int id) throws Exception 
    {
        List<Enrollment> enroll = getListStudentEnrollments(id);
        StringBuilder r = new StringBuilder();
        
        for (Enrollment e : enroll)
        {
            r.append(e.getHTMLTableStudent());
        }
        
        return r.toString();
    }
    
    public String getHTMLStudentEnrollments(int id) throws Exception
    {
        return toHTMLStudentEnrollments(id);
    }
    
    public static String getHTMLStudentEnrollments(String id){
        try {
            return new SetEnrollments().getHTMLStudentEnrollments(Integer.parseInt(id));
        } catch (Exception ex) {
            
        }
        return "";
    }
    
}