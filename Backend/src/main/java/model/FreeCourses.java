package model;

import java.io.IOException;
import model.beans.SetSchedules;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.Course;
import model.beans.CourseGroup;
import model.beans.Enrollment;
import model.beans.GenericUser;
import model.beans.Professor;
import model.beans.Schedule;
import model.beans.SetCourseGroups;
import model.beans.SetCourses;
import model.beans.SetEnrollments;
import model.beans.SetSpecialities;
import model.beans.Student;
import model.beans.UserAccountData;
import model.dao.AdministratorDAO;
import model.dao.ConditionDAO;
import model.dao.CourseDAO;
import model.dao.CourseGroupDAO;
import model.dao.EnrollmentDAO;
import model.dao.ProfessorDAO;
import model.dao.RolDAO;
import model.dao.ScheduleDAO;
import model.dao.StudentDAO;
import model.dao.UserAccountDataDAO;

public class FreeCourses {

    public FreeCourses() {
    }

    public GenericUser signIn(int indentification, String password) throws Exception {

        GenericUser user = null;
        try {
            user = new StudentDAO().retrieve(indentification);
        } catch (IllegalArgumentException ex) {

            try {
                user = new ProfessorDAO().retrieve(indentification);
            } catch (IllegalArgumentException ex1) {
                user = new AdministratorDAO().retrieve(indentification);
            }
        }

        if (Objects.isNull(user) || !user.getAccData().getPassword().equals(password)) {
            throw new IllegalArgumentException();
        }

        return user;
    }

    public String signUp(int identification, String lastName1, String lastName2, String name, int telephoneNumber, String email, String userName) throws IOException, SQLException {

        UserAccountData accData;
        String password = RandomPassword.getInstance().generate();
        RolDAO dao = new RolDAO();
        accData = new UserAccountData(userName, dao.retrieve(3), password, new Date(System.currentTimeMillis()), false);

        Student student = new Student(identification, accData, lastName1, lastName2, name, telephoneNumber, email);

        new UserAccountDataDAO().add(accData.getId(), accData);
        new StudentDAO().add(student.getId(), student);

        return password;
    }

    public String signUpProfessor(int identification, String lastName1, String lastName2, String name, int telephoneNumber, String email, String userName) throws IOException, SQLException {
        UserAccountData accData;
        String password = RandomPassword.getInstance().generate();
        RolDAO dao = new RolDAO();
        accData = new UserAccountData(userName, dao.retrieve(2), password, new Date(System.currentTimeMillis()), false);

        Professor professor = new Professor(identification, accData, lastName1, lastName2, name, telephoneNumber, email);

        new UserAccountDataDAO().add(accData.getId(), accData);
        new ProfessorDAO().add(professor.getId(), professor);

        return password;
    }

    public String getAssignedGroups(int professorId) throws Exception {
        return new SetCourseGroups().getTableProfessorGroups(professorId);
    }

    public static String getAssignedGroupsStatic(GenericUser user) {
        try {
            return new FreeCourses().getAssignedGroups(user.getId());
        } catch (Exception ex) {
            Logger.getLogger(FreeCourses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public void assignNote(String identifier, int grade) throws IOException, SQLException {
        Enrollment e = new EnrollmentDAO().retrieve(identifier);
        e.setGrade(grade);
        if (e.getGrade() >= 7) {
            e.setCondition(new ConditionDAO().retrieve(1));
        } else if (e.getGrade() == 6) {
            e.setCondition(new ConditionDAO().retrieve(2));
        } else {
            e.setCondition(new ConditionDAO().retrieve(3));
        }
        new EnrollmentDAO().update(identifier, e);
    }

    public String getGroupEnrollments(int groupNumber) throws Exception {
        return new SetEnrollments().getTableGroupNumber(groupNumber);
    }

    public static String getGroupEnrollmentsStatic(CourseGroup group) {
        try {
            return new FreeCourses().getGroupEnrollments(group.getGroupNumber());
        } catch (Exception ex) {
            Logger.getLogger(FreeCourses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String getCourses(String filter) throws Exception {
       return new SetCourses().getTableCourses(filter);
    }

    public String getStudentEnrollments(int id) throws Exception {
        return new SetEnrollments().getHTMLStudentEnrollments(id);
    }
    
    public String getCourseSchedules(int courseId) throws Exception {
        return new SetSchedules().getTableSchedules(courseId);
    }

    public void enrollCourseStudent(int groupNumber, int id) throws IOException, SQLException {
        CourseGroup cg = new SetCourseGroups().retrieve(groupNumber);
        new SetEnrollments().add(new Enrollment(new StudentDAO().retrieve(id), cg, cg.getCourse(), new ConditionDAO().retrieve(4), 0));
    }

    public static String getHTMLAreasFilter(String idCourse) {
        try {
            return new SetSpecialities().getOptionsAreas(new CourseDAO().retrieve(Integer.parseInt(idCourse)).getThematicArea().getId());
        } catch (Exception ex) {
            Logger.getLogger(FreeCourses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public void registerGroup(int idCourse, int groupNumber, int idProfessor, int day, int hour) throws IOException, SQLException {
        CourseGroup cp = new CourseGroup(groupNumber, new CourseDAO().retrieve(idCourse), new ProfessorDAO().retrieve(idProfessor));
        new CourseGroupDAO().add(cp.getGroupNumber(), cp);
        new ScheduleDAO().add(0, new Schedule(0, cp, cp.getCourse(), day, hour));

    }

    public void addCourse(Course course) {
        try {
            new SetCourses().add(course);
        } catch (Exception ex) {
            Logger.getLogger(FreeCourses.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
