/*
    Universidad Nacional de Costa Rica
    Escuela de Informática
    EIF209 Programación IV, ciclo I 2021
    Mauricio Gutiérrez Vásquez 118260119
    Adolfo Di Carlo Martínez Martínez 118050228
    Yeikol Villalobos Herrera 702670531
    Proyecto #1, Sistema web CursosLibres.com
*/

package frontend.services;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.beans.GenericUser;
import model.beans.SearchFilter;

public class FilterAllCoursesAdminService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {

            HttpSession session = request.getSession(true);
            GenericUser user = (GenericUser) session.getAttribute("user");

            if (!Objects.isNull(user) && user.getAccData().getRol().getId() == 1) {
                
                String parameterSearch = request.getParameter(PARAMETER_ID_PARAM);
                if (Objects.isNull(parameterSearch)) {
                    throw new IllegalArgumentException();
                }
                
                request.setAttribute("searchParameter", new SearchFilter(parameterSearch));
                request.getRequestDispatcher("listcourses.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "No es posible acceder a la información");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } catch (IllegalArgumentException ex) {
            request.setAttribute("message", "No es posible acceder a la información");
            request.getRequestDispatcher("error.jsp").forward(request, response);
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

    private static final String PARAMETER_ID_PARAM = "parameter";
}
