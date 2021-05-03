package frontend.services;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FreeCourses;
import model.beans.SetProfessors;
import model.beans.SetSpecialities;
import model.beans.SetThematicAreas;
import model.beans.Speciality;

@WebServlet(name = "RegisterProfessorService", urlPatterns = {"/RegisterProfessorService"})
public class RegisterProfessorService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Enumeration<String> parameters = request.getParameterNames();
        int identification = Integer.parseInt(request.getParameter(parameters.nextElement()));
        String lastName1 = request.getParameter(parameters.nextElement());
        String lastName2 = request.getParameter(parameters.nextElement());
        String name = request.getParameter(parameters.nextElement());
        int telephoneNumber = Integer.parseInt(request.getParameter(parameters.nextElement()));
        String email = request.getParameter(parameters.nextElement());
        String userName = request.getParameter(parameters.nextElement());

        FreeCourses logic = new FreeCourses();

        try {

            String password = logic.signUpProfessor(identification, lastName1, lastName2, name, telephoneNumber, email, userName);
            SetSpecialities ss = new SetSpecialities();
            while (parameters.hasMoreElements()) {
                ss.add(new Speciality(new SetProfessors().retrieve(identification), new SetThematicAreas().retrieve(Integer.parseInt(request.getParameter(parameters.nextElement())))));
            }
            request.setAttribute("message", String.format("Registro con exito, su clave es: %s", password));
            request.getRequestDispatcher("professorregister.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("message", ex.toString());
            request.getRequestDispatcher("professorregister.jsp").forward(request, response);
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
