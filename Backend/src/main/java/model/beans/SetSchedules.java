
package model.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.ScheduleDAO;


public class SetSchedules extends Set<Integer, Schedule>
{
    public SetSchedules() throws Exception
    {
        super(new ScheduleDAO());
    }

    @Override
    public void add(Schedule newGroupableObject) throws SQLException, IOException
    {
        Schedule schedule = (Schedule) newGroupableObject;
        dao.add(schedule.getCourse(), schedule);
    }

    @Override
    public void update(Schedule newGroupableObject) throws SQLException, IOException
    {
       Schedule schedule = (Schedule) newGroupableObject;
        dao.add(schedule.getCourse(), schedule);
    }

    @Override
    public Schedule retrieve(Integer id) throws Exception
    {
        return (Schedule) dao.retrieve(id);
    }

    @Override
    protected String toHTML() throws Exception
    {
        return null;
    }
    
    public List<Schedule> listAllScheduleFilter(int idCourse) throws Exception
    {
        List<Schedule> schedule = listAll();
        List<Schedule> scheduleFiltrer = new ArrayList<>();
        
        for(Schedule c : schedule)
        {
            if(c.getCourse().getId() == idCourse)
            {
                scheduleFiltrer.add(c);
            }
        }
        
        return scheduleFiltrer;
    }
    
    protected String toHTMLAllSchedules(int idCourse) throws Exception
    {
        List<Schedule> schedule = listAllScheduleFilter(idCourse);
        StringBuilder r = new StringBuilder();
        
        for(Schedule c : schedule)
        {
            r.append(c.getHTMLTable());
        }
        
        return r.toString();
    }
    
    public String getTableSchedules(int idCourse) throws Exception
    {
        return toHTMLAllSchedules(idCourse);
    }
    
    public static String getTableSchedules(String idCourse){
        try {
            return new SetSchedules().getTableSchedules(Integer.parseInt(idCourse));
        } catch (Exception ex) {
            
        }
        return "";
    }
    
    
    protected String toHTMLAllSchedulesAdmin(int idCourse) throws Exception
    {
        List<Schedule> schedule = listAllScheduleFilter(idCourse);
        StringBuilder r = new StringBuilder();
        
        for(Schedule c : schedule)
        {
            r.append(c.getHTMLTableAdmin());
        }
        
        return r.toString();
    }
    
    public String getTableSchedulesAdmin(int idCourse) throws Exception
    {
        return toHTMLAllSchedulesAdmin(idCourse);
    }
    
    public static String getTableSchedulesAdmin(String idCourse){
        try {
            return new SetSchedules().getTableSchedulesAdmin(Integer.parseInt(idCourse));
        } catch (Exception ex) {
            
        }
        return "";
    }
}