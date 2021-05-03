package frontend.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FreeCourses;

@WebServlet(name = "RegisterGroupService", urlPatterns = {"/RegisterGroupService"})
public class RegisterGroupService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int idProfessor = Integer.parseInt(request.getParameter(PROFESOR_ID_PARAM));
        int idCourse = Integer.parseInt(request.getParameter(COURSE_ID_PARAM));
        int day = Integer.parseInt(request.getParameter(DAY_ID_PARAM));
        int hour = Integer.parseInt(request.getParameter(HOUR_ID_PARAM));
        int groupNumber = Integer.parseInt(request.getParameter(GROUP_NUMBER_ID_PARAM));
        
        try {   
            new FreeCourses().registerGroup(idCourse, groupNumber, idProfessor, day, hour);
            response.sendRedirect("adminpanel.jsp");
        } catch (Exception ex) {
            response.sendRedirect("index.jsp");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static final String PROFESOR_ID_PARAM = "professor";
    private static final String COURSE_ID_PARAM = "idCourse";
    private static final String DAY_ID_PARAM = "day";
    private static final String HOUR_ID_PARAM = "hour";
    private static final String GROUP_NUMBER_ID_PARAM = "groupNumber";
    
}
