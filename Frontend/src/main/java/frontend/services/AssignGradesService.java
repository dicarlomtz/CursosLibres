package frontend.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FreeCourses;
import model.beans.GenericUser;

@WebServlet(name = "AssignGradesService", urlPatterns = {"/AssignGradesService"})
public class AssignGradesService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        GenericUser user = (GenericUser) session.getAttribute("user");

        if (!Objects.isNull(user) && user.getAccData().getRol().getId() == 2) {

            Enumeration<String> identifiers = request.getParameterNames();
            FreeCourses logic = new FreeCourses();

            while (identifiers.hasMoreElements()) {
                try {
                    String identifier = identifiers.nextElement();
                    int grade = Integer.parseInt(request.getParameter(identifier));
                    logic.assignNote(identifier, grade);
                    response.sendRedirect("professorpanel.jsp");
                } catch (NumberFormatException e) {
                    response.sendRedirect("index.jsp");
                } catch (SQLException | IOException ex) {
                    request.setAttribute("message", "No es posible accesar a la información");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            }
        } else {
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

}
