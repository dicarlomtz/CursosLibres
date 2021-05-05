/*
    Universidad Nacional de Costa Rica
    Escuela de Informática
    EIF209 Programación IV, ciclo I 2021
    Mauricio Gutiérrez Vásquez 118260119
    Adolfo Di Carlo Martínez Martínez 118050228
    Yeikol Villalobos Herrera 702670531
    Proyecto #1, Sistema web CursosLibres.com
*/

package model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.sql.SQLException;
import model.beans.SetEnrollments;
import java.util.List;
import model.beans.Enrollment;

public class ExportPDF
{
    private ExportPDF()
    {
    
    }
    
    public static ExportPDF getInstance()
    {
        if(instance == null)
        {
            instance = new ExportPDF();
        }
        
        return instance;
    }
    
    public void generatePDF(int id) throws IOException, SQLException 
    {
        Document documento = new Document();
        SetEnrollments enroll = new SetEnrollments();
        List<Enrollment> list = enroll.getListStudentEnrollments(id);
        
        try
        {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Constancia_" + id + ".pdf"));
            documento.open();
            
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("ID estudiante");
            tabla.addCell("ID curso");
            tabla.addCell("Descripción");
            tabla.addCell("Número de grupo");
            tabla.addCell("Estado");
            tabla.addCell("Nota");
            
            for (Enrollment l : list)
            {
                tabla.addCell(String.format("%d", id));
                tabla.addCell(String.format("%d", l.getCourse().getId()));
                tabla.addCell(l.getCourse().getDescription());
                tabla.addCell(String.format("%d", l.getGroup().getGroupNumber()));
                tabla.addCell(l.getCondition().getDescription());
                tabla.addCell(String.format("%d", l.getGrade()));
            }
            
            documento.add(tabla);
            documento.close();
        }
        catch(DocumentException | FileNotFoundException e)
        {
        }
    }
    
    private static ExportPDF instance = null;
}
