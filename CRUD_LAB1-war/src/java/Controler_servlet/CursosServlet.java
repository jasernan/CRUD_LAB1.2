/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler_servlet;

import CRUD_LAB1.entity.Curso;
import CRUD_LAB1.session.CursoFacadeLocal;
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
 * @author julia
 */
@WebServlet(name = "CursosServlet", urlPatterns = {"/CursosServlet"})
public class CursosServlet extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String codigoCursoStr = request.getParameter("codigoCurso");
        int codigoCurso = codigoCursoStr.equals("") ? 0 : Integer.parseInt(codigoCursoStr);
        String nombreCurso = request.getParameter("nombreCurso");
        String numeroCreditosStr = request.getParameter("numeroCreditos");
        int numeroCreditos = numeroCreditosStr.equals("") ? 0 : Integer.parseInt(numeroCreditosStr);
        String semestreStr = request.getParameter("semestre");
        int semestre = semestreStr.equals("") ? 0 : Integer.parseInt(semestreStr);
        String numeroEstudiantesAdmitidosStr = request.getParameter("numeroEstudiantesAdmitidos");
        int numeroEstudiantesAdmitidos = numeroEstudiantesAdmitidosStr.equals("") ? 0 : Integer.parseInt(numeroEstudiantesAdmitidosStr);
    
    
    Curso curso = new Curso (codigoCurso,nombreCurso,numeroCreditos,semestre,numeroEstudiantesAdmitidos);
    
    if (action.equalsIgnoreCase("Add")) {
            cursoFacade.addCurso(curso);
    }else if (action.equalsIgnoreCase("Edit")) {
            cursoFacade.editCurso(curso);
    }else if (action.equalsIgnoreCase("Delete")) {
            cursoFacade.deleteCurso(codigoCurso);
    }else if (action.equalsIgnoreCase("Search")) {
            curso = cursoFacade.getCurso(codigoCurso);
    }else 
    
        cursoFacade.create(curso);
    response.setContentType("text/html;charset=UTF-8");
    
    request.setAttribute("curso", curso);
    request.setAttribute("allCursos", cursoFacade.getAllcursos());
    request.getRequestDispatcher("cursosInfo.jsp").forward(request, response);
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
