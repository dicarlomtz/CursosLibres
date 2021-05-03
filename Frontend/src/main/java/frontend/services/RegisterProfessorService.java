package frontend.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FreeCourses;
import model.beans.GenericUser;
import model.beans.SetProfessors;
import model.beans.SetSpecialities;
import model.beans.SetThematicAreas;
import model.beans.Speciality;

@WebServlet(name = "RegisterProfessorService", urlPatterns = {"/RegisterProfessorService"})
public class RegisterProfessorService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {

            Enumeration<String> parameters = request.getParameterNames();
            int identification = Integer.parseInt(request.getParameter(parameters.nextElement()));
            String lastName1 = request.getParameter(parameters.nextElement());
            String lastName2 = request.getParameter(parameters.nextElement());
            String name = request.getParameter(parameters.nextElement());
            int telephoneNumber = Integer.parseInt(request.getParameter(parameters.nextElement()));
            String email = request.getParameter(parameters.nextElement());
            String userName = request.getParameter(parameters.nextElement());

            FreeCourses logic = new FreeCourses();

            HttpSession session = request.getSession(true);
            GenericUser user = (GenericUser) session.getAttribute("user");

            if (!Objects.isNull(user) && user.getAccData().getRol().getId() == 1) {
                if (parameters.hasMoreElements()) {
                    String password = logic.signUpProfessor(identification, lastName1, lastName2, name, telephoneNumber, email, userName);
                    SetSpecialities ss = new SetSpecialities();
                    while (parameters.hasMoreElements()) {
                        ss.add(new Speciality(new SetProfessors().retrieve(identification), new SetThematicAreas().retrieve(Integer.parseInt(request.getParameter(parameters.nextElement())))));
                    }
                    request.setAttribute("message", String.format("Registro con exito, su clave es: %s", password));
                    request.getRequestDispatcher("professorregister.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "Debe seleccionar al menos una especialidad");
                    request.getRequestDispatcher("professorregister.jso").forward(request, response);
                }
            } else {
                response.sendRedirect("index.jsp");
            }

        }  catch (IOException | SQLException ex) {
            request.setAttribute("message", "Usuario o identificación invalidos");
            request.getRequestDispatcher("professorregister.jsp").forward(request, response);
        } catch(NumberFormatException ex1) {
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
