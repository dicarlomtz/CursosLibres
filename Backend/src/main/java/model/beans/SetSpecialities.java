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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.CourseDAO;
import model.dao.SpecialityDAO;

public class SetSpecialities extends Set<Integer, Speciality> {

    public SetSpecialities() throws IOException {
        super(new SpecialityDAO());
    }

   
    @Override
    public void add(Speciality item) throws SQLException, IOException {
        dao.add(item.getProfessor().getId(), item);
    }

    @Override
    public void update(Speciality item) throws SQLException, IOException {

    }

    @Override
    public Speciality retrieve(Integer id) throws SQLException, IOException {
        return null;
    }

    @Override
    protected String toHTML() throws SQLException, IOException {
        return null;
    }

     public List<Speciality> listAllSpecialitiesFilter(int idThematicArea) throws SQLException, IOException {
        List<Speciality> specialities = listAll();
        List<Speciality> specialitiesFilter = new ArrayList<>();

        for (Speciality s : specialities) {
            if (s.getThematicArea().getId() == idThematicArea) {
                specialitiesFilter.add(s);
            }
        }

        return specialitiesFilter;
    }

    protected String toHTMLAllSpecialitiesFilter(int idThematicArea) throws SQLException, IOException {
        List<Speciality> specialities = listAllSpecialitiesFilter(idThematicArea);
        StringBuilder r = new StringBuilder();

        for (Speciality s : specialities) {
            r.append(s.getHTMLOptionAreaProfessor());
            
        }

        return r.toString();
    }

    public String getOptionsAreas(int idThematicArea) throws SQLException, IOException {
        return toHTMLAllSpecialitiesFilter(idThematicArea);
    }
    
    public static String getOptionsAreas(String idCourse){
        try {
            return new SetSpecialities().getOptionsAreas(new CourseDAO().retrieve(Integer.parseInt(idCourse)).getThematicArea().getId());
        } catch (Exception ex) {
            Logger.getLogger(SetSpecialities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
