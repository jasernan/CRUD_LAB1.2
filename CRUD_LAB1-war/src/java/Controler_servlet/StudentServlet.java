/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler_servlet;



import CRUD_LAB1.entity.Student;
import CRUD_LAB1.session.StudentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gilberto-pedraza
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String studentIdStr = request.getParameter("studentId");
        int studentId = studentIdStr.equals("") ? 0 : Integer.parseInt(studentIdStr);
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String yearLevelStr = request.getParameter("yearLevel");
        int yearLevel=yearLevelStr.equals("") ? 0 : Integer.parseInt(yearLevelStr);
        
        
        
        
        Student student=new Student(studentId,firstName,lastName,yearLevel);
        
        if (action.equalsIgnoreCase("Add")) {
            studentFacade.addStudent(student);
        }else if (action.equalsIgnoreCase("Edit")) {
            studentFacade.editstudent(student);
        }else if (action.equalsIgnoreCase("Delete")) {
            studentFacade.deleteStudent(studentId);
        }else if (action.equalsIgnoreCase("Search")) {
            student = studentFacade.getStudent(studentId);
        }else 
            
        studentFacade.create(student);
        response.setContentType("text/html;charset=UTF-8");
       
        request.setAttribute("student", student);
        request.setAttribute("allStudents", studentFacade.getAllstudents());
        request.getRequestDispatcher("studentInfo.jsp").forward (request,response);
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
