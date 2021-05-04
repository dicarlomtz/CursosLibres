package frontend.services;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet(name = "SignInService", urlPatterns = {"/SignInService"})
public class SignInService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {

            int indentification = Integer.parseInt(request.getParameter(IDENTIFICATION_ID_PARAM));
            String password = request.getParameter(PASSWORD_ID_PARAM);

            FreeCourses logic = new FreeCourses();

            HttpSession session = request.getSession(true);

            if (Objects.isNull(session.getAttribute("user"))) {

                GenericUser user = logic.signIn(indentification, password);

                session.setAttribute("user", user);

                session.setAttribute("id", user.getId());

            }
            response.sendRedirect("index.jsp");

        } catch (NumberFormatException ex) {
            request.setAttribute("message", "No es posible acceder a la información");
            request.getRequestDispatcher("signin.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("message", "No es posible acceder a la información, credenciales pueden ser incorrectas");
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

    private static final String IDENTIFICATION_ID_PARAM = "identification";
    private static final String PASSWORD_ID_PARAM = "password";

}
