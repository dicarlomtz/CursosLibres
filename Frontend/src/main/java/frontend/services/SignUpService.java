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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FreeCourses;

@WebServlet(name = "SignUpService", urlPatterns = {"/SignUpService"})
public class SignUpService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {

            int identification = Integer.parseInt(request.getParameter(IDENTIFICATION_ID_PARAM));
            String lastName1 = request.getParameter(LASTNAME1_ID_PARAM);
            String lastName2 = request.getParameter(LASTNAME2_ID_PARAM);
            String name = request.getParameter(NAME_ID_PARAM);
            int telephoneNumber = Integer.parseInt(request.getParameter(TELEPHONENUMBER_ID_PARAM));
            String email = request.getParameter(EMAIL_ID_PARAM);
            String userName = request.getParameter(USERNAME_ID_PARAM);

            FreeCourses logic = new FreeCourses();

            HttpSession session = request.getSession(true);

            if (Objects.isNull(session.getAttribute("user"))) {
                String password = logic.signUp(identification, lastName1, lastName2, name, telephoneNumber, email, userName);
                request.setAttribute("message", String.format("Registro con exito, su clave es: %s", password));
                request.getRequestDispatcher("signin.jsp").forward(request, response);
            } else {
                response.sendRedirect("index.jsp");
            }

        } catch (NumberFormatException ex) {
            request.setAttribute("message", "No es posible acceder a la información");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("message", "Usuario o identificación no validos");
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

    private static final String IDENTIFICATION_ID_PARAM = "identification";
    private static final String LASTNAME1_ID_PARAM = "lastName1";
    private static final String LASTNAME2_ID_PARAM = "lastName2";
    private static final String NAME_ID_PARAM = "name";
    private static final String TELEPHONENUMBER_ID_PARAM = "telephoneNumber";
    private static final String EMAIL_ID_PARAM = "email";
    private static final String USERNAME_ID_PARAM = "userName";
}
