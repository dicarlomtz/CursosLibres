package frontend.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FreeCourses;
import model.beans.GenericUser;

@WebServlet(name = "EnrollGroupStudentService", urlPatterns = {"/EnrollGroupStudentService"})
public class EnrollGroupStudentService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        GenericUser user = (GenericUser) session.getAttribute("user");
        if (!Objects.isNull(user) && user.getAccData().getRol().getId() == 1) {
            int groupNumber = Integer.parseInt(request.getParameter("groupNumber"));
            FreeCourses logic = new FreeCourses();
            try {
                logic.enrollCourseStudent(groupNumber, user.getId());
                response.sendRedirect("studentpanel.jsp");
            } catch (IOException | SQLException ex) {
                request.setAttribute("message", "No es posible acceder a la información");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            response.sendRedirect("studentpanel.jsp");
        } else {
            request.setAttribute("message", "Primero debe registrarse");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
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
